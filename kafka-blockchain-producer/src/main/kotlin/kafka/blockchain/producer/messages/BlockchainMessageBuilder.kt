package kafka.blockchain.producer.messages

import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.protocol.core.methods.response.EthBlock
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.protocol.parity.methods.response.Trace
import java.math.BigInteger
import kafka.blockchain.producer.messages.Messages.*
import kafka.blockchain.producer.parity.ParityWebSocketsService

class BlockchainMessageBuilder {

    private val parityService = ParityWebSocketsService().startParity()

    fun buildBlock(ethBlock: EthBlock.Block): Block {
        val blockTraces = getBlockTraces(ethBlock.number)
        val transactions = getTransactions(ethBlock.transactions)
        return Block.newBuilder()
            .setHash(ethBlock.hash)
            .setNumber(ethBlock.number.toString())
            .setTimestamp(ethBlock.timestamp.toString())
            .addAllTransactions(transactions)
            .addAllTraces(blockTraces)
            .build()
    }

    private fun buildTrace(blockTrace: Trace): Messages.Trace {
        val traceBuilder = Messages.Trace.newBuilder()
        val traceAction = blockTrace.action
        when (traceAction) {
            is Trace.CreateAction -> {
                buildCreateAction(traceAction)
                traceBuilder.setAction(Messages.Trace.Action.CREATE)
            }
            is Trace.CallAction -> {
                buildCallAction(traceAction)
                traceBuilder.setAction(Messages.Trace.Action.CALL)
            }
            is Trace.RewardAction -> {
                buildRewardAction(traceAction)
                traceBuilder.setAction(Messages.Trace.Action.REWARD)
            }
            is Trace.SuicideAction -> {
                buildSuicideAction(traceAction)
                traceBuilder.setAction(Messages.Trace.Action.SUICIDE)
            }
            else -> null
        }
        val result = buildResult(blockTrace)
        val traceAddresses = blockTrace.traceAddress.map { ta -> ta.toString() }
        traceBuilder
            .setResult(result)
            .setSubtracesCount(blockTrace.subtraces.toString())
            .setType(blockTrace.type)
            .addAllTraceAddress(traceAddresses)
            .setError(blockTrace.error ?: "")
            .setTransactionPosition(blockTrace.transactionPosition?.toString() ?: "")
        val trace = traceBuilder.build()
        return trace
    }

    private fun buildResult(blockTrace: Trace): Result {
        return Result.newBuilder()
            .setAddress(blockTrace.result?.address ?: "")
            .setCode(blockTrace.result?.code ?: "")
            .setGasUsed(blockTrace.result?.gasUsed.toString())
            .setOutput(blockTrace.result?.output ?: "")
            .build()
    }

    private fun buildSuicideAction(traceAction: Trace.SuicideAction): Suicide {
        return Suicide.newBuilder()
            .setAddress(traceAction.address)
            .setBalance(traceAction.balance.toString())
            .setRefundAddress(traceAction.refundAddress)
            .build()
    }

    private fun buildRewardAction(traceAction: Trace.RewardAction): Messages.Reward {
        return Messages.Reward.newBuilder()
            .setAuthor(traceAction.author)
            .setValue(traceAction.value.toString())
            .setType(traceAction.rewardType)
            .build()
    }

    private fun buildCallAction(traceAction: Trace.CallAction): Messages.Call {
        return Messages.Call.newBuilder()
            .setType(traceAction.callType)
            .setFrom(traceAction.from)
            .setGas(traceAction.gas.toString())
            .setInput(traceAction.input)
            .setTo(traceAction.to)
            .setValue(traceAction.value.toString())
            .build()
    }

    private fun buildCreateAction(traceAction: Trace.CreateAction): Messages.Create {
        return Messages.Create.newBuilder()
            .setFrom(traceAction.from)
            .setGas(traceAction.gas.toString())
            .setInit(traceAction.init)
            .setValue(traceAction.value.toString())
            .build()
    }

    private fun getTransactions(transactions: List<EthBlock.TransactionResult<Any>>): List<Messages.Transaction> {
        return transactions
            .map { t ->
                val ethTransaction: EthBlock.TransactionObject = t as EthBlock.TransactionObject
                buildTransaction(ethTransaction)
            }
    }

    private fun getReceipt(transactionHash: String?): Receipt {
        val receipt = parityService.ethGetTransactionReceipt(transactionHash).send().transactionReceipt.get()
        return buildReceipt(receipt)
    }

    private fun buildReceipt(receipt: TransactionReceipt): Receipt {
        return Receipt.newBuilder()
            .setGasUsed(receipt.gasUsed.toString())
            .setStatus(receipt.status)
            .build()
    }

    private fun getBlockTraces(blockNumber: BigInteger?): List<Messages.Trace> {
        return parityService.traceBlock(DefaultBlockParameter.valueOf(blockNumber)).send().traces
            .filter { trace: Trace -> trace.transactionHash == null }
            .map { trace: Trace -> buildTrace(trace) }
            .toList()
    }

    private fun buildTransaction(transaction: EthBlock.TransactionObject): Messages.Transaction {
        val traces = getTraces(transaction.hash)
        val receipt = getReceipt(transaction.hash)
        val transactionBuilder = Messages.Transaction.newBuilder()
            .setChainId(transaction.chainId)
            .setCreates(transaction.creates)
            .setFrom(transaction.from)
            .setGas(transaction.gas.toString())
            .setGas(transaction.gasPrice.toString())
            .setHash(transaction.hash)
            .setInput(transaction.input)
            .setNonce(transaction.nonce.toString())
            .setPublicKey(transaction.publicKey)
            .setTo(transaction.to)
            .setIndex(transaction.transactionIndex.toString())
            .setIndexRaw(transaction.transactionIndexRaw)
            .setValue(transaction.value.toString())
            .setSrv(Messages.SRV.newBuilder().setS(transaction.s).setR(transaction.r).setV(transaction.v).build())
            .addAllTraces(traces)
            .setReceipt(receipt)
        return transactionBuilder.build()
    }

    private fun getTraces(transactionHash: String?): List<Messages.Trace> {
        return parityService.traceTransaction(transactionHash).send()
            .traces.map { trace: Trace -> buildTrace(trace) }
            .toList()
    }

}
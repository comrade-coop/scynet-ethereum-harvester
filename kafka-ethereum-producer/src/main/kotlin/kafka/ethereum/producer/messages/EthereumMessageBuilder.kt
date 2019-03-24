package kafka.ethereum.producer.messages

import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.protocol.core.methods.response.EthBlock
import org.web3j.protocol.core.methods.response.Log
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.protocol.parity.methods.response.Trace
import java.math.BigInteger
import org.web3j.protocol.parity.Parity

class EthereumMessageBuilder(
    private val parityService: Parity
) {

    fun buildBlock(ethBlock: EthBlock.Block): Messages.Block {
        val blockTraces = getBlockTraces(ethBlock.number)
        val transactions = getTransactions(ethBlock.transactions)
        return Messages.Block.newBuilder()
            .setAuthor(ethBlock.author)
            .setHash(ethBlock.hash)
            .setNumber(ethBlock.number.toString())
            .setTimestamp(ethBlock.timestamp?.toString().orEmpty())
            .addAllTransactions(transactions)
            .addAllTraces(blockTraces)
            .setSize(ethBlock.size?.toString().orEmpty())
            .setDifficulty(ethBlock.difficulty?.toString().orEmpty())
            .setTotalDifficulty(ethBlock.totalDifficulty?.toString().orEmpty())
            .setGasUsed(ethBlock.gasUsed?.toString().orEmpty())
            .setGasLimit(ethBlock.gasLimit?.toString().orEmpty())
            .build()
    }

    private fun buildTrace(blockTrace: Trace): Messages.Trace {
        Messages.getDescriptor()
        val traceBuilder = Messages.Trace.newBuilder()
        val traceAction = blockTrace.action
        when (traceAction) {
            is Trace.CreateAction -> {
                traceBuilder.setCreate(buildCreateAction(traceAction))
                traceBuilder.setAction(Messages.Trace.Action.CREATE)
            }
            is Trace.CallAction -> {
                traceBuilder.setCall(buildCallAction(traceAction))
                traceBuilder.setAction(Messages.Trace.Action.CALL)
            }
            is Trace.RewardAction -> {
                traceBuilder.setReward(buildRewardAction(traceAction))
                traceBuilder.setAction(Messages.Trace.Action.REWARD)
            }
            is Trace.SuicideAction -> {
                traceBuilder.setSuicide(buildSuicideAction(traceAction))
                traceBuilder.setAction(Messages.Trace.Action.SUICIDE)
            }
        }
        val result = buildResult(blockTrace)
        val traceAddresses = blockTrace.traceAddress.map { ta -> ta.toString() }
        traceBuilder
            .setResult(result)
            .setSubtracesCount(blockTrace.subtraces?.toString().orEmpty())
            .setType(blockTrace.type.orEmpty())
            .addAllTraceAddress(traceAddresses)
            .setError(blockTrace.error.orEmpty())
            .setTransactionPosition(blockTrace.transactionPosition?.toString().orEmpty())
        val trace = traceBuilder.build()
        return trace
    }

    private fun buildResult(blockTrace: Trace): Messages.Result {
        return Messages.Result.newBuilder()
            .setAddress(blockTrace.result?.address.orEmpty())
            .setCode(blockTrace.result?.code.orEmpty())
            .setGasUsed(blockTrace.result?.gasUsed?.toString().orEmpty())
            .setOutput(blockTrace.result?.output.orEmpty())
            .build()
    }

    private fun buildSuicideAction(traceAction: Trace.SuicideAction): Messages.Suicide {
        return Messages.Suicide.newBuilder()
            .setAddress(traceAction.address.orEmpty())
            .setBalance(traceAction.balance?.toString().orEmpty())
            .setRefundAddress(traceAction.refundAddress.orEmpty())
            .build()
    }

    private fun buildRewardAction(traceAction: Trace.RewardAction): Messages.Reward {
        return Messages.Reward.newBuilder()
            .setAuthor(traceAction.author.orEmpty())
            .setValue(traceAction.value?.toString().orEmpty())
            .setType(traceAction.rewardType.orEmpty())
            .build()
    }

    private fun buildCallAction(traceAction: Trace.CallAction): Messages.Call {
        return Messages.Call.newBuilder()
            .setType(traceAction.callType.orEmpty())
            .setFrom(traceAction.from.orEmpty())
            .setGas(traceAction.gas?.toString().orEmpty())
            .setInput(traceAction.input.orEmpty())
            .setTo(traceAction.to.orEmpty())
            .setValue(traceAction.value?.toString().orEmpty())
            .build()
    }

    private fun buildCreateAction(traceAction: Trace.CreateAction): Messages.Create {
        return Messages.Create.newBuilder()
            .setFrom(traceAction.from.orEmpty())
            .setGas(traceAction.gas?.toString().orEmpty())
            .setInit(traceAction.init.orEmpty())
            .setValue(traceAction.value?.toString().orEmpty())
            .build()
    }

    private fun getReceipt(transactionHash: String?): Messages.Receipt {
        val receipt = parityService.ethGetTransactionReceipt(transactionHash).send().transactionReceipt.get()
        return buildReceipt(receipt)
    }

    private fun buildReceipt(receipt: TransactionReceipt): Messages.Receipt {
        return Messages.Receipt.newBuilder()
            .setGasUsed(receipt.gasUsed?.toString().orEmpty())
            .setStatus(receipt.status.orEmpty())
            .addAllLogs(buildLogs(receipt.logs))
            .build()
    }

    private fun buildLogs(ethLogs: List<Log>): List<Messages.Log> {
        return ethLogs
            .map { ethLog: Log -> buildLog(ethLog) }
            .toList()
    }

    private fun buildLog(ethLog: Log): Messages.Log {
        return Messages.Log.newBuilder()
            .addAllTopics(ethLog.topics)
            .build()
    }

    private fun getBlockTraces(blockNumber: BigInteger?): List<Messages.Trace> {
        return parityService.traceBlock(DefaultBlockParameter.valueOf(blockNumber)).send().traces
            .filter { trace: Trace -> trace.transactionHash == null }
            .map { trace: Trace -> buildTrace(trace) }
            .toList()
    }

    private fun getTransactions(transactions: List<EthBlock.TransactionResult<Any>>): List<Messages.Transaction> {
        return transactions
            .map { t ->
                val ethTransaction: EthBlock.TransactionObject = t as EthBlock.TransactionObject
                buildTransaction(ethTransaction)
            }
    }

    private fun buildTransaction(transaction: EthBlock.TransactionObject): Messages.Transaction {
        val traces = getTraces(transaction.hash)
        val receipt = getReceipt(transaction.hash)
        return Messages.Transaction.newBuilder()
            .setChainId(transaction.chainId ?: 0L)
            .setCreates(transaction.creates.orEmpty())
            .setFrom(transaction.from.orEmpty())
            .setGas(transaction.gas?.toString().orEmpty())
            .setGasPrice(transaction.gasPrice?.toString().orEmpty())
            .setHash(transaction.hash.orEmpty())
            .setInput(transaction.input.orEmpty())
            .setNonce(transaction.nonce?.toString().orEmpty())
            .setPublicKey(transaction.publicKey.orEmpty())
            .setTo(transaction.to.orEmpty())
            .setIndex(transaction.transactionIndex?.toString().orEmpty())
            .setIndexRaw(transaction.transactionIndexRaw.orEmpty())
            .setValue(transaction.value?.toString().orEmpty())
            .setSrv(buildSRV(transaction))
            .addAllTraces(traces)
            .setReceipt(receipt)
            .build()
    }

    private fun buildSRV(transaction: EthBlock.TransactionObject): Messages.SRV {
        return Messages.SRV.newBuilder()
            .setS(transaction.s.orEmpty())
            .setR(transaction.r.orEmpty())
            .setV(transaction.v)
            .build()
    }

    private fun getTraces(transactionHash: String?): List<Messages.Trace> {
        return parityService.traceTransaction(transactionHash).send()
            .traces.map { trace: Trace -> buildTrace(trace) }
            .toList()
    }

}

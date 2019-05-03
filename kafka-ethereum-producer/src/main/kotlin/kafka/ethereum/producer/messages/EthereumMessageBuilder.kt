package kafka.ethereum.producer.messages

import harvester.common.messages.Messages
import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.protocol.core.methods.response.EthBlock
import org.web3j.protocol.core.methods.response.Log
import org.web3j.protocol.parity.methods.response.Trace
import java.math.BigInteger
import org.web3j.protocol.parity.Parity
import java.util.function.Predicate

class EthereumMessageBuilder(
    private val parityService: Parity
) {
    private var transactionTraces: ArrayList<Messages.Trace> = ArrayList()
    private var blockTraces: ArrayList<Messages.Trace> = ArrayList()
    private var logs: ArrayList<Log> = ArrayList()

    fun buildBlock(ethBlock: EthBlock.Block): Messages.Block {

        transactionTraces.clear()
        blockTraces.clear()
        logs.clear()

        loadTraces(ethBlock.number)
        loadLogs(ethBlock.number)

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

    private fun loadLogs(blockNumber: BigInteger?){
        val logs = parityService.ethGetFilterLogs(blockNumber!!).send().logs
        if (logs != null){
            logs.map { l ->
                val log = l as Log
                this.logs.add(log)
            }
        }
    }

    private fun buildTrace(trace: Trace): Messages.Trace {
        val beforeTraceBuild = System.currentTimeMillis()
        Messages.getDescriptor()
        val traceBuilder = Messages.Trace.newBuilder()
        val traceAction = trace.action
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
        val result = buildResult(trace)
        val traceAddresses = trace.traceAddress.map { ta -> ta.toString() }
        traceBuilder
            .setResult(result)
            .setSubtracesCount(trace.subtraces?.toString().orEmpty())
            .setType(trace.type.orEmpty())
            .addAllTraceAddress(traceAddresses)
            .setError(trace.error.orEmpty())
            .setTransactionPosition(trace.transactionPosition?.toString().orEmpty())
            .setTransactionHash(trace.transactionHash.orEmpty())
       return traceBuilder.build()
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

    private fun buildReceipt(transactionHash: String?): Messages.Receipt {
        val logs = this.logs.filter {  l -> l.transactionHash == transactionHash }
        return Messages.Receipt.newBuilder()
            .addAllLogs(buildLogs(logs))
            .build()
    }

    private fun buildLogs(ethLogs: List<Log>): List<Messages.Log> {
        return ethLogs
            .map { ethLog: Log -> buildLog(ethLog) }
    }

    private fun buildLog(ethLog: Log): Messages.Log {
        return Messages.Log.newBuilder()
            .addAllTopics(ethLog.topics)
            .build()
    }

    private fun loadTraces(blockNumber: BigInteger?) {
        parityService.traceBlock(DefaultBlockParameter.valueOf(blockNumber!!)).send().traces
            .map { trace: Trace ->
                if (trace.transactionHash == null) {
                    blockTraces.add(buildTrace(trace))
                } else {
                    transactionTraces.add(buildTrace(trace))
                }
            }
    }

    private fun getTransactions(transactions: List<EthBlock.TransactionResult<Any>>): List<Messages.Transaction> {
        return transactions
            .map { t ->
                val ethTransaction: EthBlock.TransactionObject = t as EthBlock.TransactionObject
                buildTransaction(ethTransaction)
            }
    }

    private fun buildTransaction(transaction: EthBlock.TransactionObject): Messages.Transaction {
        val traces = transactionTraces.filter { trace -> trace.transactionHash == transaction.hash }
        //transactionTraces.removeIf(Predicate { trace -> trace.transactionHash == transaction.hash })
        val receipt = buildReceipt(transaction.hash)
        val transactionM = Messages.Transaction.newBuilder()
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
        return transactionM
    }

    private fun buildSRV(transaction: EthBlock.TransactionObject): Messages.SRV {
        return Messages.SRV.newBuilder()
            .setS(transaction.s.orEmpty())
            .setR(transaction.r.orEmpty())
            .setV(transaction.v)
            .build()
    }
}

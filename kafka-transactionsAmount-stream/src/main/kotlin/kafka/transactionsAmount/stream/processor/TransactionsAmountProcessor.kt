package kafka.transactionsAmount.stream.processor

import kafka.transactionsAmount.stream.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger

class TransactionsAmountProcessor : Processor<String, Messages.Block> {

    private val TRANSACTIONS_AMOUNT = "transactionsAmount"
    private val ZERO = "0"

    private var context: ProcessorContext? = null
    private var blockNumberTransactionsAmountStore: KeyValueStore<String, String>? = null

    override fun process(blockNumber: String, block: Messages.Block) {
        try {
            process(block)
        } catch (e: Exception) {
            // TODO use logger for this
            println("Exception occurred: $e while processing block: $blockNumber")
        }
    }

    private fun process(block: Messages.Block) {
        extractTransactionsAmount(block)
        context!!.forward(block.number, getTransactionsAmount())
        context!!.commit()
    }

    override fun init(context: ProcessorContext) {
        this.context = context
        this.blockNumberTransactionsAmountStore = context.getStateStore("BlockNumberTransactionsAmountStore") as KeyValueStore<String, String>
    }

    override fun close() {
    }

    private fun extractTransactionsAmount(block: Messages.Block) {
        blockNumberTransactionsAmountStore!!.putIfAbsent(TRANSACTIONS_AMOUNT, ZERO)
        extractTransactionsAmountFromGas(block)
        extractTransactionsAmountFromTraces(block)
    }

    private fun extractTransactionsAmountFromGas(block: Messages.Block) {
        var rewardForBlockAuthor = "0"
        block.transactionsList.forEach { transaction ->
            rewardForBlockAuthor = TransactionsAmountCalculator.sum(rewardForBlockAuthor, TransactionsAmountCalculator.multiply(transaction.receipt.gasUsed, transaction.gasPrice))
        }
        updateBlockNumberTransactionsAmountStore(rewardForBlockAuthor)
    }

    private fun extractTransactionsAmountFromTraces(block: Messages.Block) {
        val traces = block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
        traces.forEach { trace ->
            when (trace.type) {
                "reward" -> updateBlockNumberTransactionsAmountStore(trace.reward.value)
                "call" -> {
                    updateBlockNumberTransactionsAmountStore(trace.call.value)
                }
                "suicide" -> updateBlockNumberTransactionsAmountStore(trace.suicide.balance)
                "create" -> updateBlockNumberTransactionsAmountStore(trace.create.value)
            }
        }
    }

    private fun getTransactionsAmount(): String {
        return blockNumberTransactionsAmountStore!!.get(TRANSACTIONS_AMOUNT)
    }

    private fun updateBlockNumberTransactionsAmountStore(amount: String) {
        val updatedTransactionsAmount = BigInteger(getTransactionsAmount()).add(BigInteger(amount))
        blockNumberTransactionsAmountStore!!.put(TRANSACTIONS_AMOUNT, updatedTransactionsAmount.toString())
    }
}
package kafka.transactionCount.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureTickProcessor
import harvester.common.processor.FeatureCalculationStrategy
import java.math.BigInteger

class TransactionCountProcessor : BlockFeatureTickProcessor("transactionCount", FeatureCalculationStrategy.AMOUNT, null) {

    override fun extract(block: Messages.Block) {
        val transactionCount = extractTransactionCountFromTraces(block)

        updateStores(transactionCount)
    }

    private fun extractTransactionCountFromTraces(block: Messages.Block): String {
        var transactionCount = BigInteger.ZERO
        val traces = getTraces(block)
        traces.forEach { trace ->
            when (trace.type) {
                "reward" -> transactionCount++
                "call" -> {
                    transactionCount++
                }
                "suicide" -> {
                    transactionCount++
                }
                "create" -> {
                    transactionCount++
                }
            }
        }
        return transactionCount.toString()
    }

    private fun getTraces(block: Messages.Block): List<Messages.Trace> {
        return block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
    }

}

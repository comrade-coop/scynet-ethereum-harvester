package kafka.ETHSupply.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureAmountProcessor
import harvester.common.processor.FeatureCalculator
import java.math.BigInteger

class ETHSupplyProcessor : BlockFeatureAmountProcessor("ETHSupply") {

    override fun getFeatureValue(block: Messages.Block): String {
        return getBlockReward(block)
    }

    private fun getBlockReward(block: Messages.Block): String {
        val traces = getTraces(block)
        traces.forEach { trace ->
            when (trace.type) {
                "reward" -> return FeatureCalculator.weiToEth(trace.reward.value)
            }
        }
        return BigInteger.ZERO.toString()
    }

    private fun getTraces(block: Messages.Block): List<Messages.Trace> {
        return block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
    }

}

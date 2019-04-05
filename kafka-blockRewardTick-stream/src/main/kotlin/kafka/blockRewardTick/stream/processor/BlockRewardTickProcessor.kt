package kafka.blockRewardTick.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureTickProcessor
import harvester.common.processor.FeatureCalculationStrategy

class BlockRewardTickProcessor : BlockFeatureTickProcessor("blockReward", FeatureCalculationStrategy.AVERAGE) {

    private val ZERO = "0"

    override fun extract(block: Messages.Block) {
        val blockReward = getBlockReward(block)

        updateStores(blockReward)
    }

    private fun getBlockReward(block: Messages.Block): String {
        val traces = getTraces(block)
        traces.forEach { trace ->
            when (trace.type) {
                "reward" -> return trace.reward.value
            }
        }
        return ZERO
    }

    private fun getTraces(block: Messages.Block): List<Messages.Trace> {
        return block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
    }

}

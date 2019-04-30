package kafka.gasUsedTick.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureTickProcessor
import harvester.common.processor.FeatureCalculationStrategy

class GasUsedTickProcessor : BlockFeatureTickProcessor("gasUsed", FeatureCalculationStrategy.AVERAGE, null) {

    override fun extract(block: Messages.Block) {
        val gasUsed = block.gasUsed

        updateStores(gasUsed)
    }

}

package kafka.gasUsedTick.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureTickProcessor

class GasUsedTickProcessor : BlockFeatureTickProcessor("gasUsed") {

    override fun extract(block: Messages.Block) {
        val gasUsed = block.gasUsed

        addToBlockNumberFeatureStore(gasUsed)
        addToFeatureStore(gasUsed)
    }

}

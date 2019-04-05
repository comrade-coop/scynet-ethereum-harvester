package kafka.gasUsed.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureProcessor

class GasUsedProcessor : BlockFeatureProcessor() {
    override fun getFeatureValue(block: Messages.Block): String {
        return block.gasUsed
    }

}

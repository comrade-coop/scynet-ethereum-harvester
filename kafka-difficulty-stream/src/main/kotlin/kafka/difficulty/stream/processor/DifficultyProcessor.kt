package kafka.difficulty.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureProcessor

class DifficultyProcessor : BlockFeatureProcessor() {
    override fun getFeatureValue(block: Messages.Block): String {
        return block.difficulty
    }

}

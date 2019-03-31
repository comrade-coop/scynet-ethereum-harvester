package kafka.difficulty.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureTickProcessor

class DifficultyTickProcessor : BlockFeatureTickProcessor("difficulty") {

    override fun extract(block: Messages.Block) {
        val difficulty = block.difficulty

        addToBlockNumberFeatureStore(difficulty)
        addToFeatureStore(difficulty)
    }

}

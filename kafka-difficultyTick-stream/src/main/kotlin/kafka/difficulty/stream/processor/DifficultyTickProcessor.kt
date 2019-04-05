package kafka.difficulty.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureTickProcessor
import harvester.common.processor.FeatureCalculationStrategy

class DifficultyTickProcessor : BlockFeatureTickProcessor("difficulty", FeatureCalculationStrategy.AVERAGE, null) {

    override fun extract(block: Messages.Block) {
        val difficulty = block.difficulty

        updateStores(difficulty)
    }

}

package kafka.difficulty.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureTickProcessor
import harvester.common.processor.FeatureCalculator

class DifficultyTickProcessor : BlockFeatureTickProcessor("difficulty") {

    override fun extract(block: Messages.Block) {
        val difficulty = block.difficulty

        addToBlockNumberFeatureStore(difficulty)
        addToFeatureStore(difficulty)
    }

    private fun addToBlockNumberFeatureStore(difficulty: String) {
        val builder = blockNumberFeatureStore!!.get(currentBlockNumber).toBuilder()
        builder.putAddressFeature(PROPERTY, difficulty)
        blockNumberFeatureStore!!.put(currentBlockNumber, builder.build())
    }

    private fun addToFeatureStore(difficulty: String) {
        val oldValue = featureStore!!.get(PROPERTY)
        println(oldValue)
        featureStore!!.put(PROPERTY, FeatureCalculator.sum(oldValue, difficulty))
    }

}

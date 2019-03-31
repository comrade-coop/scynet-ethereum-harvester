package kafka.gasUsedTick.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureTickProcessor
import harvester.common.processor.FeatureCalculator

class GasUsedTickProcessor : BlockFeatureTickProcessor("gasUsed") {

    override fun extract(block: Messages.Block) {
        val gasUsed = block.gasUsed

        addToBlockNumberFeatureStore(gasUsed)
        addToFeatureStore(gasUsed)
    }

    private fun addToBlockNumberFeatureStore(gasUsed: String) {
        val builder = blockNumberFeatureStore!!.get(currentBlockNumber).toBuilder()
        builder.putAddressFeature(PROPERTY, gasUsed)
        blockNumberFeatureStore!!.put(currentBlockNumber, builder.build())
    }

    private fun addToFeatureStore(gasUsed: String) {
        val oldValue = featureStore!!.get(PROPERTY)
        println(oldValue)
        featureStore!!.put(PROPERTY, FeatureCalculator.sum(oldValue, gasUsed))
    }

}

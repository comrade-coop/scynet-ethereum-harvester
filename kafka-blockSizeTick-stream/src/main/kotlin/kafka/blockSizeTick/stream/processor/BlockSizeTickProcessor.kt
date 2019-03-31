package kafka.blockSizeTick.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureTickProcessor
import harvester.common.processor.FeatureCalculator

class BlockSizeTickProcessor : BlockFeatureTickProcessor("blockSizeTick") {

    override fun extract(block: Messages.Block) {
        val blockSize = block.size

        addToBlockNumberFeatureStore(blockSize)
        addToFeatureStore(blockSize)
    }

    private fun addToBlockNumberFeatureStore(blockSize: String) {
        val builder = blockNumberFeatureStore!!.get(currentBlockNumber).toBuilder()
        builder.putAddressFeature(PROPERTY, blockSize)
        blockNumberFeatureStore!!.put(currentBlockNumber, builder.build())
    }

    private fun addToFeatureStore(blockSize: String) {
        val oldValue = featureStore!!.get(PROPERTY)
        println(oldValue)
        featureStore!!.put(PROPERTY, FeatureCalculator.sum(oldValue, blockSize))
    }

}

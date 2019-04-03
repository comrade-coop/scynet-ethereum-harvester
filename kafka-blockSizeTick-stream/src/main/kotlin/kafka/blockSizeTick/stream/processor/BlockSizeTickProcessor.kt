package kafka.blockSizeTick.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureTickProcessor
import harvester.common.processor.FeatureCalculationStrategy

class BlockSizeTickProcessor : BlockFeatureTickProcessor("blockSize", FeatureCalculationStrategy.AVERAGE) {

    override fun extract(block: Messages.Block) {
        val blockSize = block.size

        updateStores(blockSize)
    }

}

package kafka.blockSizeTick.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureTickProcessor

class BlockSizeTickProcessor : BlockFeatureTickProcessor("blockSize") {

    override fun extract(block: Messages.Block) {
        val blockSize = block.size

        addToBlockNumberFeatureStore(blockSize)
        addToFeatureStore(blockSize)
    }

}

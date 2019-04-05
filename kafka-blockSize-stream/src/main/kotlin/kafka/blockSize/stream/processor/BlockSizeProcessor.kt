package kafka.blockSize.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureProcessor

class BlockSizeProcessor : BlockFeatureProcessor() {

    override fun getFeatureValue(block: Messages.Block): String {
        return block.size
    }

}

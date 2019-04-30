package kafka.blockchainGrowth.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureTickProcessor
import harvester.common.processor.FeatureCalculationStrategy

class BlockchainGrowthTickProcessor : BlockFeatureTickProcessor("blockchainGrowth", FeatureCalculationStrategy.AMOUNT, null) {

    override fun extract(block: Messages.Block) {
        val blockSize = block.size

        updateStores(blockSize)
    }

}

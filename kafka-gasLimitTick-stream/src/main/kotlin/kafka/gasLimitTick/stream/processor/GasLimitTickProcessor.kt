package kafka.gasLimitTick.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureTickProcessor
import harvester.common.processor.FeatureCalculationStrategy

class GasLimitTickProcessor : BlockFeatureTickProcessor("gasLimit", FeatureCalculationStrategy.AVERAGE) {

    override fun extract(block: Messages.Block) {
        val gasLimit = block.gasLimit

        updateStores(gasLimit)
    }

}

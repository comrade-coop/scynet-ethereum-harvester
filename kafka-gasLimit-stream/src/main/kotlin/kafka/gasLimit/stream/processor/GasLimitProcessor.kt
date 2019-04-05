package kafka.gasLimit.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureProcessor

class GasLimitProcessor : BlockFeatureProcessor() {

    override fun getFeatureValue(block: Messages.Block): String {
        return block.gasLimit
    }

}

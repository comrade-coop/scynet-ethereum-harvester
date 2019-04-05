package harvester.common.processor

import harvester.common.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext

abstract class BlockFeatureProcessor : Processor<String, Messages.Block> {

    private var context: ProcessorContext? = null

    override fun process(blockNumber: String, block: Messages.Block) {
        try {
            process(block)
        } catch (e: Exception) {
            // TODO use logger for this
            println("Exception occurred: $e while processing block: $blockNumber")
        }
    }

    protected abstract fun getFeatureValue(block: Messages.Block): String

    private fun process(block: Messages.Block) {
        val blockNumber = block.number
        val featureValue = getFeatureValue(block)
        println("Processing block with number: $blockNumber with feature value: $featureValue")

        context!!.forward(block.number, featureValue)
        context!!.commit()
    }

    override fun init(context: ProcessorContext?) {
        this.context = context
    }

    override fun close() {}
}

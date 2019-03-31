package kafka.difficulty.stream.processor

import harvester.common.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext

class DifficultyProcessor : Processor<String, Messages.Block> {

    private var context: ProcessorContext? = null

    override fun process(blockNumber: String, block: Messages.Block) {
        try {
            process(block)
        } catch (e: Exception) {
            // TODO use logger for this
            println("Exception occurred: $e while processing block: $blockNumber")
        }
    }

    private fun process(block: Messages.Block) {
        context!!.forward(block.number, block.difficulty)
        context!!.commit()
    }

    override fun init(context: ProcessorContext?) {
        this.context = context
    }

    override fun close() {}
}

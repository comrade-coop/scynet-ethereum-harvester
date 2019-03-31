package kafka.blockSize.stream.processor

import harvester.common.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext

class BlockSizeProcessor : Processor<String, Messages.Block> {

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
        val blockNumber = block.number
        val blockSize = block.size

        println("Block number: $blockNumber with block size: $blockSize")

        context!!.forward(blockNumber, blockSize)
        context!!.commit()
    }

    override fun init(context: ProcessorContext?) {
        this.context = context
    }

    override fun close() {}
}

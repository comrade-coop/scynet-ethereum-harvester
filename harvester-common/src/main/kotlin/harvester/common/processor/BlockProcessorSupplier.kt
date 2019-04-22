package harvester.common.processor

import harvester.common.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorSupplier

class BlockProcessorSupplier(private val processor: Processor<String, Messages.Block>): ProcessorSupplier<String, Messages.Block> {
    override fun get(): Processor<String, Messages.Block> {
       return processor
    }
}
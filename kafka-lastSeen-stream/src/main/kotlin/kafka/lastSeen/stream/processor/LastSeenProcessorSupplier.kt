package kafka.lastSeen.stream.processor

import org.apache.kafka.streams.processor.ProcessorSupplier
import kafka.lastSeen.stream.messages.Messages
import org.apache.kafka.streams.processor.Processor

class LastSeenProcessorSupplier: ProcessorSupplier<String, Messages.Block> {
    override fun get(): Processor<String, Messages.Block> {
        return LastSeenProcessor()
    }
}
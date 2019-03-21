package kafka.volumeOut.stream.processor

import org.apache.kafka.streams.processor.ProcessorSupplier
import kafka.volumeOut.stream.messages.Messages
import org.apache.kafka.streams.processor.Processor

class VolumeOutProcessorSupplier: ProcessorSupplier<String, Messages.Block> {
    override fun get(): Processor<String, Messages.Block> {
        return VolumeOutProcessor()
    }
}
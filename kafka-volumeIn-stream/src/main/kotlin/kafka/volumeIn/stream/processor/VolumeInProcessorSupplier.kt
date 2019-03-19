package kafka.volumeIn.stream.processor

import org.apache.kafka.streams.processor.ProcessorSupplier
import kafka.volumeIn.stream.messages.Messages
import org.apache.kafka.streams.processor.Processor

class VolumeInProcessorSupplier: ProcessorSupplier<String, Messages.Block> {
    override fun get(): Processor<String, Messages.Block> {
        return VolumeInProcessor()
    }
}
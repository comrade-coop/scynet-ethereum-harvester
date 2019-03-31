package kafka.gasUsedTick.stream.processor

import harvester.common.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorSupplier

class GasUsedTickProcessorSupplier: ProcessorSupplier<String, Messages.Block> {
    override fun get(): Processor<String, Messages.Block> {
        return GasUsedTickProcessor()
    }
}
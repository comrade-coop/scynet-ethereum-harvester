package kafka.difficultyTick.stream.processor

import harvester.common.messages.Messages
import org.apache.kafka.streams.processor.ProcessorSupplier
import org.apache.kafka.streams.processor.Processor

class DifficultyTickProcessorSupplier: ProcessorSupplier<String, Messages.Block> {
    override fun get(): Processor<String, Messages.Block> {
        return DifficultyTickProcessor()
    }
}

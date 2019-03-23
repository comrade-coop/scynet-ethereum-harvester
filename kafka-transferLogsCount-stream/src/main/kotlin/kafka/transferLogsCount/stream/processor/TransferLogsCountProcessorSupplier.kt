package kafka.transferLogsCount.stream.processor

import kafka.transferLogsCount.stream.messages.Messages
import org.apache.kafka.streams.processor.ProcessorSupplier
import org.apache.kafka.streams.processor.Processor

class TransferLogsCountProcessorSupplier: ProcessorSupplier<String, Messages.Block> {
    override fun get(): Processor<String, Messages.Block> {
        return TransferLogsCountProcessor()
    }
}
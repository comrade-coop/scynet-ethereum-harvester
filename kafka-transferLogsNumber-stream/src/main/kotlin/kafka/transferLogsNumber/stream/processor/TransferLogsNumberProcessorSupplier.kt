package kafka.transferLogsNumber.stream.processor

import kafka.transferLogsNumber.stream.messages.Messages
import org.apache.kafka.streams.processor.ProcessorSupplier
import org.apache.kafka.streams.processor.Processor

class TransferLogsNumberProcessorSupplier: ProcessorSupplier<String, Messages.Block> {
    override fun get(): Processor<String, Messages.Block> {
        return TransferLogsNumberProcessor()
    }
}
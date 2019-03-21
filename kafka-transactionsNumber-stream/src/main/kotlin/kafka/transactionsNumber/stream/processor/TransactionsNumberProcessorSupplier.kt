package kafka.transactionsNumber.stream.processor

import org.apache.kafka.streams.processor.ProcessorSupplier
import kafka.transactionsNumber.stream.messages.Messages
import org.apache.kafka.streams.processor.Processor

class TransactionsNumberProcessorSupplier: ProcessorSupplier<String, Messages.Block> {
    override fun get(): Processor<String, Messages.Block> {
        return TransactionsNumberProcessor()
    }
}
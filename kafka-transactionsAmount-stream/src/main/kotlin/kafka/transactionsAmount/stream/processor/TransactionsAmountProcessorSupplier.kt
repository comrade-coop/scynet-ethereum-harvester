package kafka.transactionsAmount.stream.processor

import kafka.transactionsAmount.stream.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorSupplier

class TransactionsAmountProcessorSupplier : ProcessorSupplier<String, Messages.Block> {
    override fun get(): Processor<String, Messages.Block> {
        return TransactionsAmountProcessor()
    }
}
package kafka.transactionCount.stream.processor

import harvester.common.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorSupplier

class TransactionCountProcessorSupplier: ProcessorSupplier<String, Messages.Block> {
    override fun get(): Processor<String, Messages.Block> {
        return TransactionCountProcessor()
    }
}
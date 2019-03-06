package kafka.balance.stream

import kafka.balance.stream.messages.Messages
import org.apache.kafka.streams.KeyValue
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorSupplier


class Supplier: ProcessorSupplier<String, Messages.Block> {
    override fun get(): Processor<String, Messages.Block> {
        return  AddressBalanceProcessor()
    }
}
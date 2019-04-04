package kafka.ERC20Transfers.stream.processor

import harvester.common.messages.Messages
import org.apache.kafka.streams.processor.ProcessorSupplier
import org.apache.kafka.streams.processor.Processor

class ERC20TransferProcessorSupplier: ProcessorSupplier<String, Messages.Block> {
    override fun get(): Processor<String, Messages.Block> {
        return ERC20TransfersProcessor()
    }
}
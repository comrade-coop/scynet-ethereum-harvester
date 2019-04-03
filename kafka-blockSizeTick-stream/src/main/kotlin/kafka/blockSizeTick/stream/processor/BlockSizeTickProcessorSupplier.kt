package kafka.blockSizeTick.stream.processor

import harvester.common.messages.Messages
import org.apache.kafka.streams.processor.ProcessorSupplier
import org.apache.kafka.streams.processor.Processor

class BlockSizeTickProcessorSupplier : ProcessorSupplier<String, Messages.Block> {
    override fun get(): Processor<String, Messages.Block> {
        return BlockSizeTickProcessor()
    }
}
package harvester.common.processor

import harvester.common.messages.StreamJoin
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorSupplier

class DistributionProcessorSupplier(private val processor: Processor<String, StreamJoin.Join>  ): ProcessorSupplier<String, StreamJoin.Join> {
    override fun get(): Processor<String, StreamJoin.Join> {
        return processor
    }
}
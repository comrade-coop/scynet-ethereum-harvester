package kafka.balanceLastSeen.distribution.processor

import harvester.common.messages.StreamJoin
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorSupplier

class DistributionProcessorSupplier: ProcessorSupplier<String, StreamJoin.Join> {
    override fun get(): Processor<String, StreamJoin.Join> {
        return DistributionProcessor()
    }
}
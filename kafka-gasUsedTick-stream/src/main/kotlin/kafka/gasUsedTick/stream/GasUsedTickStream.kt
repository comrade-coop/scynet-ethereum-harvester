package kafka.gasUsedTick.stream

import harvester.common.config.BlockFeatureStreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.gasUsedTick.stream.processor.GasUsedTickProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology

fun main() {
    GasUsedTickStream().start()
}

class GasUsedTickStream {
    fun start(){
        val gasUsedTickStream =
                KafkaStreams(getTopology(), BlockFeatureStreamConfig.getStreamProperties("127.0.0.1:29092", "gasUsedTick"))
        gasUsedTickStream.cleanUp()
        gasUsedTickStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(gasUsedTickStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")

                .addProcessor("Processor", GasUsedTickProcessorSupplier(), "Ethereum-producer")
                .addStateStore(BlockFeatureStreamConfig.getFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getBlockNumberFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("GasUsedTick-stream", "gasUsedTick", "Processor")
        return topology
    }
}

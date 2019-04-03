package kafka.gasLimitTick.stream

import harvester.common.config.BlockFeatureStreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.gasLimitTick.stream.processor.GasLimitTickProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology

fun main() {
    GasLimitTickStream().start()
}

class GasLimitTickStream {
    fun start(){
        val gasLimitTickStream =
                KafkaStreams(getTopology(), BlockFeatureStreamConfig.getStreamProperties("127.0.0.1:29092", "gasLimitTick"))
        gasLimitTickStream.cleanUp()
        gasLimitTickStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(gasLimitTickStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")

                .addProcessor("Processor", GasLimitTickProcessorSupplier(), "Ethereum-producer")
                .addStateStore(BlockFeatureStreamConfig.getFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getBlockNumberFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("GasLimitTick-stream", "gasLimitTick", "Processor")
        return topology
    }
}

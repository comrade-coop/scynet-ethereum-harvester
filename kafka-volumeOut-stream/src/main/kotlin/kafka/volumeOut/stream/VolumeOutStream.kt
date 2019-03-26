package kafka.volumeOut.stream

import harvester.common.config.BlockFeatureStreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.volumeOut.stream.processor.VolumeOutProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*

fun main(args: Array<String>) {
    VolumeOutStream().start()
}

class VolumeOutStream() {
    fun start() {
        val volumeOutStream =
                KafkaStreams(getTopology(), BlockFeatureStreamConfig.getStreamProperties("127.0.0.1:29092", "volumeOut"))
        volumeOutStream.cleanUp()
        volumeOutStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(volumeOutStream::close))
    }

    fun getTopology(): Topology {
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")

                .addProcessor("Processor", VolumeOutProcessorSupplier(), "Ethereum-producer")
                .addStateStore(BlockFeatureStreamConfig.getAddressFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getBlockNumberAddressFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("VolumeOut-stream", "volumeOut", "Processor")
        return topology
    }
}

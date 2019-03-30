package kafka.volumeIn.stream

import harvester.common.config.AddressFeatureStreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.volumeIn.stream.processor.VolumeInProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*

fun main(args: Array<String>) {
    VolumeInStream().start()
}

class VolumeInStream(){
    fun start(){
        val volumeInStream =
                KafkaStreams(getTopology(), AddressFeatureStreamConfig.getStreamProperties("127.0.0.1:29092", "volumeIn"))
        volumeInStream.cleanUp()
        volumeInStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(volumeInStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")

                .addProcessor("Processor", VolumeInProcessorSupplier(), "Ethereum-producer")
                .addStateStore(AddressFeatureStreamConfig.getAddressFeatureStoreSupplier(), "Processor")
                .addStateStore(AddressFeatureStreamConfig.getBlockNumberAddressFeatureStoreSupplier(), "Processor")
                .addStateStore(AddressFeatureStreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("VolumeIn-stream", "volumeIn", "Processor")
        return topology
    }
}

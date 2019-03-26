package kafka.volumeIn.stream

import harvester.common.config.BlockFeatureStreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.volumeIn.stream.processor.VolumeInProcessor
import kafka.volumeIn.stream.processor.VolumeInProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*

fun main(args: Array<String>) {
    VolumeInStream().start()
}

class VolumeInStream(){
    fun start(){
        val volumeInStream =
                KafkaStreams(getTopology(), BlockFeatureStreamConfig.getStreamProperties("127.0.0.1:29092", "volumeIn"))
        volumeInStream.cleanUp()
        volumeInStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(volumeInStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")

                .addProcessor("Processor", VolumeInProcessorSupplier(), "Ethereum-producer")
                .addStateStore(BlockFeatureStreamConfig.getAddressFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getBlockNumberAddressFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("VolumeIn-stream", "volumeIn", "Processor")
        return topology
    }
}

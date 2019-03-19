package kafka.volumeIn.stream

import kafka.volumeIn.stream.config.StreamConfig
import kafka.volumeIn.stream.serialization.BlockDeserializer
import kafka.volumeIn.stream.processor.VolumeInProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*

fun main(args: Array<String>) {
    VolumeInStream().start()
}

class VolumeInStream(){
    fun start(){
        val volumeInStream = KafkaStreams(getTopology(), StreamConfig.getStreamProperties())
        volumeInStream.cleanUp()
        volumeInStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(volumeInStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")

                .addProcessor("Processor", VolumeInProcessorSupplier(), "Ethereum-producer")
                .addStateStore(StreamConfig.getAddressBalanceStoreSupplier(), "Processor")
                .addStateStore(StreamConfig.getBlockAddressBalanceStoreSupplier(), "Processor")
                .addStateStore(StreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("VolumeIn-stream", "volumeIn", "Processor")
        return topology
    }
}

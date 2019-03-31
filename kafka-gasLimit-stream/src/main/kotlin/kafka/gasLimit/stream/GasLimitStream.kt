package kafka.gasLimit.stream

import harvester.common.config.StreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.gasLimit.stream.processor.GasLimitProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*

fun main() {
    GasLimitStream().start()
}

class GasLimitStream(){
    fun start(){
        val gasLimitStream =
                KafkaStreams(getTopology(), StreamConfig.getStreamProperties("127.0.0.1:29092", "gasLimit"))
        gasLimitStream.cleanUp()
        gasLimitStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(gasLimitStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")
                .addProcessor("Processor", GasLimitProcessorSupplier(), "Ethereum-producer")
                .addStateStore(StreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("GasLimit-stream", "gasLimit", "Processor")
        return topology
    }
}

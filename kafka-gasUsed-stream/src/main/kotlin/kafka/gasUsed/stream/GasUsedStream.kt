package kafka.gasUsed.stream

import harvester.common.config.StreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.gasUsed.stream.processor.GasUsedProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology

fun main(args: Array<String>) {
    GasUsedStream().start()
}

class GasUsedStream(){
    fun start(){
        val gasUsedStream =
                KafkaStreams(getTopology(), StreamConfig.getStreamProperties("127.0.0.1:29092", "gasUsed"))
        gasUsedStream.cleanUp()
        gasUsedStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(gasUsedStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")
                .addProcessor("Processor", GasUsedProcessorSupplier(), "Ethereum-producer")
                .addStateStore(StreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("GasUsed-stream", "gasUsed", "Processor")
        return topology
    }
}

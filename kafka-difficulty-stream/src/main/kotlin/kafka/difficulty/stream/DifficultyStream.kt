package kafka.difficulty.stream

import harvester.common.config.BlockFeatureStreamConfig
import harvester.common.config.StreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.difficulty.stream.processor.DifficultyProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology

fun main() {
    DifficultyStream().start()
}

class DifficultyStream {
    fun start(){
        val difficultyStream =
                KafkaStreams(getTopology(), StreamConfig.getStreamProperties("127.0.0.1:29092", "difficulty"))
        difficultyStream.cleanUp()
        difficultyStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(difficultyStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")
                .addProcessor("Processor", DifficultyProcessorSupplier(), "Ethereum-producer")
                .addStateStore(BlockFeatureStreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("Difficulty-stream", "difficulty", "Processor")
        return topology
    }
}

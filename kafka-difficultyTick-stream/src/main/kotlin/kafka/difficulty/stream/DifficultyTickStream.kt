package kafka.difficultyTick.stream

import harvester.common.config.BlockFeatureStreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.difficultyTick.stream.processor.DifficultyTickProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*

fun main(args: Array<String>) {
    DifficultyTickStream().start()
}

class DifficultyTickStream(){
    fun start(){
        val difficultyTickStream =
                KafkaStreams(getTopology(), BlockFeatureStreamConfig.getStreamProperties("127.0.0.1:29092", "difficultyTick"))
        difficultyTickStream.cleanUp()
        difficultyTickStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(difficultyTickStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")

                .addProcessor("Processor", DifficultyTickProcessorSupplier(), "Ethereum-producer")
                .addStateStore(BlockFeatureStreamConfig.getFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getBlockNumberFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("DifficultyTick-stream", "difficultyTick", "Processor")
        return topology
    }
}

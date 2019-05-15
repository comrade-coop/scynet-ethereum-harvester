package kafka.blockchainGrowth.stream

import harvester.common.config.BlockFeatureStreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.blockchainGrowth.stream.processor.BlockchainGrowthProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology

fun main(args: Array<String>) {
    BlockchainGrowthTickStream().start()
}

class BlockchainGrowthTickStream(){
    fun start(){
        val blockchainGrowthTickStream =
                KafkaStreams(getTopology(), BlockFeatureStreamConfig.getStreamProperties("127.0.0.1:29092", "blockchainGrowthTick"))
        blockchainGrowthTickStream.cleanUp()
        blockchainGrowthTickStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(blockchainGrowthTickStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")

                .addProcessor("Processor", BlockchainGrowthProcessorSupplier(), "Ethereum-producer")
                .addStateStore(BlockFeatureStreamConfig.getFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getBlockNumberFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("BlockchainGrowthTick-stream", "blockchainGrowthTick", "Processor")
        return topology
    }
}

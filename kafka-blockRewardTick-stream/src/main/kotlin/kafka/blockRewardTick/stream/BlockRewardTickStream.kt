package kafka.blockRewardTick.stream

import harvester.common.config.BlockFeatureStreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.blockRewardTick.stream.processor.BlockRewardTickProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology

fun main() {
    BlockRewardTickStream().start()
}

class BlockRewardTickStream(){
    fun start(){
        val blockRewardTickStream =
                KafkaStreams(getTopology(), BlockFeatureStreamConfig.getStreamProperties("127.0.0.1:29092", "blockRewardTick"))
        blockRewardTickStream.cleanUp()
        blockRewardTickStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(blockRewardTickStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")

                .addProcessor("Processor", BlockRewardTickProcessorSupplier(), "Ethereum-producer")
                .addStateStore(BlockFeatureStreamConfig.getFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getBlockNumberFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("BlockRewardTick-stream", "blockRewardTick", "Processor")
        return topology
    }
}

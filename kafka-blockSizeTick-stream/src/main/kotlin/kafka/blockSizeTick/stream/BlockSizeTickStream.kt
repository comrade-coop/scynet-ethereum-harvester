package kafka.blockSizeTick.stream

import harvester.common.config.BlockFeatureStreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.blockSizeTick.stream.processor.BlockSizeTickProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*

fun main(args: Array<String>) {
    BlockSizeTickStream().start()
}

class BlockSizeTickStream(){
    fun start(){
        val blockSizeTickStream =
                KafkaStreams(getTopology(), BlockFeatureStreamConfig.getStreamProperties("127.0.0.1:29092", "blockSizeTick"))
        blockSizeTickStream.cleanUp()
        blockSizeTickStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(blockSizeTickStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")

                .addProcessor("Processor", BlockSizeTickProcessorSupplier(), "Ethereum-producer")
                .addStateStore(BlockFeatureStreamConfig.getFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getBlockNumberFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("BlockSizeTick-stream", "blockSizeTick", "Processor")
        return topology
    }
}

package kafka.blockSize.stream

import harvester.common.config.StreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.blockSize.stream.processor.BlockSizeProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*

fun main(args: Array<String>) {
    BlockSizeStream().start()
}

class BlockSizeStream(){
    fun start(){
        val blockSizeStream =
                KafkaStreams(getTopology(), StreamConfig.getStreamProperties("127.0.0.1:29092", "blockSize"))
        blockSizeStream.cleanUp()
        blockSizeStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(blockSizeStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")
                .addProcessor("Processor", BlockSizeProcessorSupplier(), "Ethereum-producer")
                .addStateStore(StreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("BlockSize-stream", "blockSize", "Processor")
        return topology
    }
}

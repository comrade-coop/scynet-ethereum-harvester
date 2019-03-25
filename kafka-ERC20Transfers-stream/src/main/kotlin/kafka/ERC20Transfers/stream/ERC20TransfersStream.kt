package kafka.ERC20Transfers.stream

import harvester.common.serialization.BlockDeserializer
import kafka.ERC20Transfers.stream.config.StreamConfig
import kafka.ERC20Transfers.stream.processor.ERC20TransferProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*

fun main(args: Array<String>) {
    ERC20TransfersStream().start()
}

class ERC20TransfersStream(){
    fun start(){
        val ERC20TransfersStream = KafkaStreams(getTopology(), StreamConfig.getStreamProperties())
        ERC20TransfersStream.cleanUp()
        ERC20TransfersStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(ERC20TransfersStream::close))
    }

    private fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")

                .addProcessor("Processor", ERC20TransferProcessorSupplier(), "Ethereum-producer")
                .addStateStore(StreamConfig.getAddressERC20TransfersStoreSupplier(), "Processor")
                .addStateStore(StreamConfig.getBlockAddressERC20TransfersSupplier(), "Processor")
                .addStateStore(StreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("ERC20Transfers-stream", "ERC20Transfers", "Processor")
        return topology
    }
}

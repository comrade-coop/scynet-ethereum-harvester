package kafka.ERC20Transfers.stream

import harvester.common.config.AddressFeatureStreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.ERC20Transfers.stream.processor.ERC20TransfersProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology

fun main(args: Array<String>) {
    ERC20TransfersStream().start()
}

class ERC20TransfersStream() {

    fun start() {

        val ERC20TransfersStream =
                KafkaStreams(getTopology(), AddressFeatureStreamConfig.getStreamProperties("127.0.0.1:29092", "ERC20Transfers"))
        ERC20TransfersStream.cleanUp()
        ERC20TransfersStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(ERC20TransfersStream::close))
    }

    private fun getTopology(): Topology {
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")
                .addProcessor("Processor", ERC20TransfersProcessorSupplier(), "Ethereum-producer")
                .addStateStore(AddressFeatureStreamConfig.getAddressFeatureStoreSupplier(), "Processor")
                .addStateStore(AddressFeatureStreamConfig.getBlockNumberAddressFeatureStoreSupplier(), "Processor")
                .addStateStore(AddressFeatureStreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("ERC20Transfers-stream", "ERC20Transfers", "Processor")
        return topology
    }
}

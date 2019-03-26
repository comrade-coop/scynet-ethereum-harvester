package kafka.transactionsNumber.stream

import harvester.common.config.BlockFeatureStreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.transactionsNumber.stream.processor.TransactionsNumberProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology

fun main(args: Array<String>) {
    TransactionsNumberStream().start()
}

class TransactionsNumberStream() {

    private val TRANSACTIONS_NUMBER = "transactionsNumber"
    fun start() {

        val transactionsNumberStream =
                KafkaStreams(getTopology(), BlockFeatureStreamConfig.getStreamProperties("127.0.0.1:29092", TRANSACTIONS_NUMBER))
        transactionsNumberStream.cleanUp()
        transactionsNumberStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(transactionsNumberStream::close))
    }

    private fun getTopology(): Topology {
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")
                .addProcessor("Processor", TransactionsNumberProcessorSupplier(), "Ethereum-producer")
                .addStateStore(BlockFeatureStreamConfig.getAddressFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getBlockNumberAddressFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("TransactionsNumber-stream", TRANSACTIONS_NUMBER, "Processor")
        return topology
    }
}

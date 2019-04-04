package kafka.transactionCount.stream

import harvester.common.config.BlockFeatureStreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.transactionCount.stream.processor.TransactionCountProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology

fun main() {
    TransactionCountStream().start()
}

class TransactionCountStream {
    fun start(){
        val transactionCountStream =
                KafkaStreams(getTopology(), BlockFeatureStreamConfig.getStreamProperties("127.0.0.1:29092", "transactionCount"))
        transactionCountStream.cleanUp()
        transactionCountStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(transactionCountStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")

                .addProcessor("Processor", TransactionCountProcessorSupplier(), "Ethereum-producer")
                .addStateStore(BlockFeatureStreamConfig.getFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getBlockNumberFeatureStoreSupplier(), "Processor")
                .addStateStore(BlockFeatureStreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("TransactionCount-stream", "transactionCount", "Processor")
        return topology
    }
}

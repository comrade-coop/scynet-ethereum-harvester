package kafka.transactionsNumber.stream

import kafka.transactionsNumber.stream.config.StreamConfig
import kafka.transactionsNumber.stream.serialization.BlockDeserializer
import kafka.transactionsNumber.stream.processor.TransactionsNumberProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*

fun main(args: Array<String>) {
    TransactionsNumberStream().start()
}

class TransactionsNumberStream(){
    fun start(){
        val transactionsNumberStream = KafkaStreams(getTopology(), StreamConfig.getStreamProperties())
        transactionsNumberStream.cleanUp()
        transactionsNumberStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(transactionsNumberStream::close));
    }

    private fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")

                .addProcessor("Processor", TransactionsNumberProcessorSupplier(), "Ethereum-producer")
                .addStateStore(StreamConfig.getAddressTransactionsNumberStoreSupplier(), "Processor")
                .addStateStore(StreamConfig.getBlockAddressTransactionsNumberSupplier(), "Processor")
                .addStateStore(StreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("TransactionsNumber-stream", "transactionsNumber", "Processor")
        return topology
    }
}

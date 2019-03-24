package kafka.transactionsAmount.stream

import kafka.transactionsAmount.stream.config.StreamConfig
import kafka.transactionsAmount.stream.processor.TransactionsAmountProcessorSupplier
import kafka.transactionsAmount.stream.serialization.BlockDeserializer
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology

fun main(args: Array<String>) {
    TransactionsAmountStream().start()
}

class TransactionsAmountStream(){
    fun start(){
        val transactionsAmountStream = KafkaStreams(getTopology(), StreamConfig.getStreamProperties())
        transactionsAmountStream.cleanUp()
        transactionsAmountStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(transactionsAmountStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")
               .addProcessor("Processor", TransactionsAmountProcessorSupplier(), "Ethereum-producer")
               .addStateStore(StreamConfig.blockNumberTransactionsAmount(), "Processor")
               .addSink("TransactionsAmount-stream", "transactionsAmount", "Processor")

        return topology
    }

}

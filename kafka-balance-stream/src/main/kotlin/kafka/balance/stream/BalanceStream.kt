package kafka.balance.stream

import harvester.common.serialization.BlockDeserializer
import kafka.balance.stream.config.StreamConfig
import kafka.balance.stream.processor.AddressBalanceProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology

fun main(args: Array<String>) {
    BalanceStream().start()
}

class BalanceStream(){
    fun start(){
        val balanceStream = KafkaStreams(getTopology(), StreamConfig.getStreamProperties())
        balanceStream.cleanUp()
        balanceStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(balanceStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")
               .addProcessor("Processor", AddressBalanceProcessorSupplier(), "Ethereum-producer")
               .addStateStore(StreamConfig.getAddressBalanceStoreSupplier(), "Processor")
               .addSink("Balance-stream", "balance", "Processor")

        return topology
    }

}

package kafka.uniqueAccounts.stream

import harvester.common.config.StreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.uniqueAccounts.stream.processor.UniqueAccountsProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*

fun main() {
    UniqueAccountsStream().start()
}

class UniqueAccountsStream(){
    fun start(){
        val uniqueAccountsStream =
                KafkaStreams(getTopology(), StreamConfig.getStreamProperties("127.0.0.1:29092", "uniqueAccounts"))
        uniqueAccountsStream.cleanUp()
        uniqueAccountsStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(uniqueAccountsStream::close))
    }

    private fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")
                .addProcessor("Processor", UniqueAccountsProcessorSupplier(), "Ethereum-producer")
                .addStateStore(StreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("UniqueAccounts-stream", "uniqueAccounts", "Processor")
        return topology
    }
}

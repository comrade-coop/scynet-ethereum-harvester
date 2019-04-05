package kafka.ETHSupply.stream

import harvester.common.config.StreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.ETHSupply.stream.processor.ETHSupplyProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology

fun main() {
    ETHSupplyStream().start()
}

class ETHSupplyStream(){
    fun start(){
        val ETHSupplyStream =
                KafkaStreams(getTopology(), StreamConfig.getStreamProperties("127.0.0.1:29092", "ETHSupply"))
        ETHSupplyStream.cleanUp()
        ETHSupplyStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(ETHSupplyStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")
                .addProcessor("Processor", ETHSupplyProcessorSupplier(), "Ethereum-producer")
                .addStateStore(StreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("ETHSupply-stream", "ETHSupply", "Processor")
        return topology
    }
}

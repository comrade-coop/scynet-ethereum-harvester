package kafka.balanceTick.stream

import harvester.common.config.AddressFeatureStreamConfig
import harvester.common.processor.BlockProcessorSupplier
import harvester.common.serialization.BlockDeserializer
import harvester.common.topics.ITopic
import harvester.common.topics.Topics
import kafka.balanceTick.stream.config.StreamConfig
import kafka.balanceTick.stream.processor.BalanceTickProcessor
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology

fun main(){
    val balanceTickStream = BalanceTickStream(Topics.BALANCE_TICK)
    balanceTickStream.start()
}

class BalanceTickStream(private val topic: ITopic){
    fun start() {
        val stream =
                KafkaStreams(getTopology(), AddressFeatureStreamConfig.getStreamProperties(APPLICATION_ID_CONFIG = topic.spell()))
        stream.cleanUp()
        stream.start()
        Runtime.getRuntime().addShutdownHook(Thread(stream::close))
    }

    fun getTopology(): Topology {
        val topology = Topology()
                .addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")
                .addProcessor("Processor", BlockProcessorSupplier(BalanceTickProcessor()), "Ethereum-producer")
                .addStateStore(AddressFeatureStreamConfig.getAddressFeatureStoreSupplier(), "Processor")
                .addStateStore(AddressFeatureStreamConfig.getBlockNumberAddressFeatureStoreSupplier(), "Processor")
                .addStateStore(AddressFeatureStreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addStateStore(StreamConfig.getAddressOccurrencesInTickStore(), "Processor")
                .addSink(topic.spell() + "-stream", topic.spell(), "Processor")
        return topology
    }
}
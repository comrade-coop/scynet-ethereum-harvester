package harvester.common.feature

import harvester.common.config.AddressFeatureStreamConfig
import harvester.common.messages.Messages
import harvester.common.processor.BlockProcessorSupplier
import harvester.common.serialization.BlockDeserializer
import harvester.common.topics.ITopic
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology
import org.apache.kafka.streams.processor.Processor

class FeatureStream(private val topic: ITopic, private val processor: Processor<String, Messages.Block>) {
    fun start() {
        try{
            val stream =
                    KafkaStreams(getTopology(), AddressFeatureStreamConfig.getStreamProperties(APPLICATION_ID_CONFIG = topic.spell()))
            stream.cleanUp()
            stream.start()
            Runtime.getRuntime().addShutdownHook(Thread(stream::close))
        }catch (e: Exception){
            System.err.println(e.toString() + ":" + e.cause)
        }
    }

    fun getTopology(): Topology {
        val topology = Topology()
                .addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")
                .addProcessor("Processor", BlockProcessorSupplier(processor), "Ethereum-producer")
                .addStateStore(AddressFeatureStreamConfig.getAddressFeatureStoreSupplier(), "Processor")
                .addStateStore(AddressFeatureStreamConfig.getBlockNumberAddressFeatureStoreSupplier(), "Processor")
                .addStateStore(AddressFeatureStreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink(topic.spell() + "-stream", topic.spell(), "Processor")
        return topology
    }
}

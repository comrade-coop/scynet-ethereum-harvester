package harvester.common.distribution

import harvester.common.config.DistributionStreamConfig
import harvester.common.distribution.stream.joiner.StreamJoiner
import harvester.common.processor.DistributionProcessor
import harvester.common.processor.DistributionProcessorSupplier
import harvester.common.serialization.JoinDeserializer
import harvester.common.topics.ITopic
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*
import java.io.FileOutputStream

class AccountNumberDistribution(topic0: ITopic, topic1: ITopic, private val processor: DistributionProcessor, resultTopic: ITopic) {

    private val joinedTopic: String = topic0.spell() + topic1.spell()
    private val resultTopic: String = resultTopic.spell()
    private val file: FileOutputStream = FileOutputStream("distributions", true)
    private val streamJoiner: StreamJoiner = StreamJoiner(topic0, topic1)

    fun start(){
        streamJoiner.start()
        val balanceLastSeenDistribution = KafkaStreams(getTopology(), DistributionStreamConfig.getStreamProperties())
        balanceLastSeenDistribution.cleanUp()
        balanceLastSeenDistribution.start()

        Runtime.getRuntime().addShutdownHook(Thread(balanceLastSeenDistribution::close))
        Runtime.getRuntime().addShutdownHook(Thread() {
            fun run(){
                file.close()
            }
        })
    }

    private fun getTopology(): Topology {
        val topology = Topology()
                .addSource("Feature-Joiner", StringDeserializer(), JoinDeserializer(), joinedTopic)
                .addProcessor("Processor", DistributionProcessorSupplier(processor), "Feature-Joiner")
                .addStateStore(DistributionStreamConfig.getMatrixStoreSupplier(), "Processor")
                .addStateStore(DistributionStreamConfig.getAddressPositionStoreSupplier(), "Processor")
                .addSink("AccountNumberDistribution-" + joinedTopic, resultTopic, "Processor")
        return topology
    }

}

package harvester.common.distribution

import harvester.common.config.DistributionStreamConfig
import harvester.common.distribution.scaler.LogTwoScaler
import harvester.common.distribution.stream.joiner.JoinedStreamJoiner
import harvester.common.distribution.stream.joiner.JoinedStreamValueJoiner
import harvester.common.distribution.stream.joiner.StreamJoiner
import harvester.common.processor.AccountBalanceDistributionProcessor
import harvester.common.processor.DistributionProcessorSupplier
import harvester.common.serialization.JoinDeserializer
import harvester.common.topics.ITopic
import harvester.common.topics.Topics
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology

fun main(){


    val streamJoiner0: StreamJoiner = StreamJoiner( Topics.BALANCE_TICK, Topics.VOLUME_OUT,"join1" )
    streamJoiner0.start()
    val streamJoiner1: StreamJoiner = StreamJoiner(Topics.VOLUME_IN, Topics.TRANSACTIONS_N, "join2")
    streamJoiner1.start()
    val distribution = AccountBalanceDistribution(Topics.VOLUME_OUT, Topics.VOLUME_IN, Topics.TRANSACTIONS_N, AccountBalanceDistributionProcessor(LogTwoScaler()))
    distribution.start()
}
class AccountBalanceDistribution(topic0: ITopic, topic1: ITopic, topic2: ITopic, private val processor: AccountBalanceDistributionProcessor) {
//    private val streamJoiner0: StreamJoiner = StreamJoiner(Topics.BALANCE_TICK, topic0)
//    private val streamJoiner1: StreamJoiner = StreamJoiner(topic1, topic2)
    private val streamJoiner: JoinedStreamJoiner = JoinedStreamJoiner(Topics.BALANCE_TICK.spell() + topic0.spell(),
                                                        topic1.spell() + topic2.spell(), "join3")
    private val joinedTopic: String = Topics.BALANCE_TICK.spell() + topic0.spell() + topic1.spell() + topic2.spell()

    fun start(){
      //  streamJoiner0.start()
        //  streamJoiner1.start()
       streamJoiner.start()

        val accountBalanceDistribution = KafkaStreams(getTopology(), DistributionStreamConfig.getStreamProperties())
        accountBalanceDistribution.cleanUp()
        accountBalanceDistribution.start()

        Runtime.getRuntime().addShutdownHook(Thread(accountBalanceDistribution::close))
    }

    private fun getTopology(): Topology{
        return Topology()
                .addSource("Feature-Joiner", StringDeserializer(), JoinDeserializer(), joinedTopic)
                .addProcessor("Processor", DistributionProcessorSupplier(processor), "Feature-Joiner")
                .addSink("AccountBalanceDistribution-" + joinedTopic, "distribution-" + joinedTopic, "Processor")
    }
}
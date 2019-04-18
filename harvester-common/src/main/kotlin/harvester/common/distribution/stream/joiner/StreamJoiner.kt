package harvester.common.distribution.stream.joiner

import harvester.common.config.DistributionStreamConfig
import harvester.common.messages.AddressFeature
import harvester.common.serialization.AddressFeatureSerdes
import harvester.common.topics.ITopic
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed

class StreamJoiner(topic0: ITopic, topic1: ITopic) {

    private val topic0: String = topic0.spell()
    private val topic1: String = topic1.spell()
    private val outputTopic: String = topic0.spell() + topic1.spell()
    fun start(){
        val builder = StreamsBuilder()

        val stream0 = builder.table<String, AddressFeature.AddressFeatureMap>(topic0, Consumed.with(Serdes.String(), AddressFeatureSerdes()))
        val stream1 = builder.table<String, AddressFeature.AddressFeatureMap>(topic1, Consumed.with(Serdes.String(), AddressFeatureSerdes()))

        val joined = stream0
                .join(stream1, StreamValueJoiner())
                .toStream().to(outputTopic)

        val balanceLastSeen = KafkaStreams(builder.build(), DistributionStreamConfig.getJoinStreamProperties())
        balanceLastSeen.cleanUp()
        balanceLastSeen.start()
        Runtime.getRuntime().addShutdownHook(Thread(balanceLastSeen::close))
    }
}
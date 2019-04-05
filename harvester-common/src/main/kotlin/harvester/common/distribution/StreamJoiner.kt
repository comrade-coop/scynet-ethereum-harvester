package harvester.common.distribution

import harvester.common.config.DistributionStreamConfig
import harvester.common.messages.AddressFeature
import harvester.common.serialization.AddressFeatureSerdes
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed

class StreamJoiner {
    fun join(streamTopic1: String, streamTopic2: String, joinedStreamTopic: String, BOOTSTRAP_SERVERS_CONFIG: String) {
        val builder = StreamsBuilder()

        val stream1 = builder.table<String, AddressFeature.AddressFeatureMap>(streamTopic1, Consumed.with(Serdes.String(), AddressFeatureSerdes()))
        val stream2 = builder.table<String, AddressFeature.AddressFeatureMap>(streamTopic2, Consumed.with(Serdes.String(), AddressFeatureSerdes()))

        stream2
                .join(stream1, ValueJoiner())
                .toStream().to(joinedStreamTopic)

        val balanceLastSeen = KafkaStreams(builder.build(), DistributionStreamConfig.getJoinStreamProperties(BOOTSTRAP_SERVERS_CONFIG))
        balanceLastSeen.cleanUp()
        balanceLastSeen.start()
        Runtime.getRuntime().addShutdownHook(Thread(balanceLastSeen::close))
    }
}
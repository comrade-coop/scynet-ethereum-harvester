package kafka.balanceLastSeen.distribution

import kafka.balanceLastSeen.distribution.config.StreamConfig
import kafka.balanceLastSeen.distribution.messages.AddressFeature
import kafka.balanceLastSeen.distribution.serialization.AddressFeatureSerdes
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed

class StreamJoiner {
    fun start(){
        val builder = StreamsBuilder()

        val lastSeenStream = builder.table<String, AddressFeature.AddressFeatureMap>("lastSeen", Consumed.with(Serdes.String(), AddressFeatureSerdes()))
        val balanceStream = builder.table<String, AddressFeature.AddressFeatureMap>("balance", Consumed.with(Serdes.String(), AddressFeatureSerdes()))

        val joined = balanceStream
                .join(lastSeenStream, ValueJoinerStreamStream())
                .toStream().to("BalanceLastSeen")

        val balanceLastSeen = KafkaStreams(builder.build(), StreamConfig.getJoinStreamProperties())
        balanceLastSeen.cleanUp()
        balanceLastSeen.start()
        Runtime.getRuntime().addShutdownHook(Thread(balanceLastSeen::close))
    }
}
package kafka.balanceLastSeen.distribution

import kafka.balanceLastSeen.distribution.messages.AddressFeature
import kafka.balanceLastSeen.distribution.messages.StreamJoin
import org.apache.kafka.streams.kstream.ValueJoiner

class ValueJoinerStreamStream: ValueJoiner<AddressFeature.AddressFeatureMap,AddressFeature.AddressFeatureMap, StreamJoin.Join> {
    override fun apply(value1: AddressFeature.AddressFeatureMap?, value2: AddressFeature.AddressFeatureMap?): StreamJoin.Join {
        val builder = StreamJoin.Join.newBuilder()
        builder.setNumberOfStreams(2)
        builder.putAllFeatureMap1(value1!!.addressFeatureMap)
        builder.putAllFeatureMap2(value2!!.addressFeatureMap)
        return builder.build()

    }
}
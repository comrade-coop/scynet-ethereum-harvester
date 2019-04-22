package harvester.common.distribution.stream.joiner

import harvester.common.messages.AddressFeature
import harvester.common.messages.StreamJoin
import org.apache.kafka.streams.kstream.ValueJoiner

class JoinedStreamValueJoiner: ValueJoiner<StreamJoin.Join, AddressFeature.AddressFeatureMap, StreamJoin.Join> {
    override fun apply(p0: StreamJoin.Join?, p1: AddressFeature.AddressFeatureMap?): StreamJoin.Join {
        val builder = p0!!.toBuilder()
        builder.setNumberOfStreams(p0.numberOfStreams + 1)
        if(p0.featureMap3Count == 0){
            builder.putAllFeatureMap3(p1!!.addressFeatureMap)
        } else if (p0.featureMap4Count == 0){
            builder.putAllFeatureMap4(p1!!.addressFeatureMap)
        }
        return builder.build()
    }
}
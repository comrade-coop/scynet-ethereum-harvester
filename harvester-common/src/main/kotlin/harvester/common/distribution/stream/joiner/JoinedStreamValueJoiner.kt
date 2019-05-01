package harvester.common.distribution.stream.joiner

import harvester.common.messages.StreamJoin
import org.apache.kafka.streams.kstream.ValueJoiner

class JoinedStreamValueJoiner: ValueJoiner<StreamJoin.Join, StreamJoin.Join, StreamJoin.Join> {
    override fun apply(p0: StreamJoin.Join?, p1: StreamJoin.Join?): StreamJoin.Join {
        val builder = StreamJoin.Join.newBuilder()
        builder.setNumberOfStreams(4)
        builder.putAllFeatureMap1(p0!!.featureMap1Map)
        builder.putAllFeatureMap2(p0.featureMap2Map)
        builder.putAllFeatureMap3(p1!!.featureMap1Map)
        builder.putAllFeatureMap4(p1.featureMap2Map)

        return builder.build()

    }
}
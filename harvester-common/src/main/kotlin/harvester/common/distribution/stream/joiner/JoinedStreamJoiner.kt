package harvester.common.distribution.stream.joiner

import harvester.common.config.DistributionStreamConfig
import harvester.common.messages.AddressFeature
import harvester.common.messages.StreamJoin
import harvester.common.serialization.AddressFeatureSerdes
import harvester.common.serialization.JoinSerdes
import harvester.common.topics.ITopic
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed

class JoinedStreamJoiner {
    private var APPLICATION_ID_CONFIG: String? = null
    private var topic0: String? = null
    private var topic1: String? = null
    private var outputTopic: String? = null

    constructor(topic0: ITopic, topic1: ITopic, APPLICATION_ID_CONFIG: String ){
        this.topic0 = topic0.spell()
        this.topic1 = topic1.spell()
        this.outputTopic = this.topic0 + this.topic1
        this.APPLICATION_ID_CONFIG = APPLICATION_ID_CONFIG
    }
    constructor(topic0: String, topic1: String,  APPLICATION_ID_CONFIG: String){
        this.topic0 = topic0
        this.topic1 = topic1
        this.outputTopic = topic0 + topic1
        this.APPLICATION_ID_CONFIG = APPLICATION_ID_CONFIG
    }
    fun start(){
        val builder = StreamsBuilder()

        val stream0 = builder.table<String, StreamJoin.Join>(topic0, Consumed.with(Serdes.String(), JoinSerdes()))
        val stream1 = builder.table<String, StreamJoin.Join>(topic1, Consumed.with(Serdes.String(), JoinSerdes()))

        val joined = stream0
                .join(stream1, JoinedStreamValueJoiner())
                .toStream().to(outputTopic)

        val stream01 = KafkaStreams(builder.build(), DistributionStreamConfig.getJoinStreamProperties(APPLICATION_ID_CONFIG = APPLICATION_ID_CONFIG!! ))
        stream01.cleanUp()
        stream01.start()
        Runtime.getRuntime().addShutdownHook(Thread(stream01::close))
    }
}
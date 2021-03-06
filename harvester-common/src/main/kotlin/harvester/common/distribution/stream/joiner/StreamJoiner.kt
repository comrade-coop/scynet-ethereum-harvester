package harvester.common.distribution.stream.joiner

import harvester.common.config.DistributionStreamConfig
import harvester.common.messages.AddressFeature
import harvester.common.serialization.AddressFeatureSerdes
import harvester.common.topics.ITopic
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed

class StreamJoiner{
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

        val stream0 = builder.table<String, AddressFeature.AddressFeatureMap>(topic0, Consumed.with(Serdes.String(), AddressFeatureSerdes()))
        val stream1 = builder.table<String, AddressFeature.AddressFeatureMap>(topic1, Consumed.with(Serdes.String(), AddressFeatureSerdes()))

        val joined = stream0
                .join(stream1, StreamValueJoiner())
                .toStream().to(outputTopic)

        val stream01 = KafkaStreams(builder.build(), DistributionStreamConfig.getJoinStreamProperties(APPLICATION_ID_CONFIG = APPLICATION_ID_CONFIG!! ))
        stream01.cleanUp()
        stream01.start()
        Runtime.getRuntime().addShutdownHook(Thread(stream01::close))
    }
}
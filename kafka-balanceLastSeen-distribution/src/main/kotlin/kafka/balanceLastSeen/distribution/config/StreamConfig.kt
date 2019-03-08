package kafka.balanceLastSeen.distribution.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.config.TopicConfig
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsConfig
import java.util.Properties
import java.util.stream.StreamSupport

class StreamConfig{
    companion object {
        fun getStreamProperties(): Properties{
            return Properties().apply {
                setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "distribution")
                setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092")
                setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
                setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
            }
        }
    }
}
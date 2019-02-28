package kafka.balanceLastSeen.distribution

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.config.TopicConfig
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.StreamsConfig
import java.util.*

val mx0 = (Math.log10(10000000.0) / Math.log10(1.2)).toLong()
val mx1 = (Math.log10(20736000.0) / Math.log10(1.2)).toLong()

fun main(args: Array<String>) {
    val config: Properties = {
        val p = Properties()
        p.put(StreamsConfig.APPLICATION_ID_CONFIG, "balanceLastSeen-distribution")
        val bootstrapServers = System.getenv("BROKER") ?: "127.0.0.1:29092"
        p.put(StreamsConfig.consumerPrefix(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG), "earliest")
        p.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
        p.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
        p.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
        p.put("cleanup.policy", TopicConfig.CLEANUP_POLICY_COMPACT)

        p.put("schema.registry.url", System.getenv("SCHEMA_REGISTRY") ?: "http://127.0.0.1:29092")
        p
    }()

    val builder = StreamsBuilder()
    val balanceStream = builder.table<String, String>("balance")

    println(mx0)
    println(mx1)
}
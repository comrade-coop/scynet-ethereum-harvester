package kafka.balanceLastSeen.distribution

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.config.TopicConfig
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.KeyValue
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.streams.kstream.Materialized
import java.math.BigInteger
import java.util.*
import kotlin.math.roundToLong

val max0 = (Math.log10(10000000.0) / Math.log10(1.2)).toLong()
val max1 = (Math.log10(20736000.0) / Math.log10(1.2)).toLong()

fun main(args: Array<String>) {
    val config: Properties = {
        val p = Properties()
        p.put(StreamsConfig.APPLICATION_ID_CONFIG, "distribution")
        val bootstrapServers = System.getenv("BROKER") ?: "127.0.0.1:29092"
        p.put(StreamsConfig.consumerPrefix(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG), "earliest")
        p.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
        p.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
        p.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
        p.put("cleanup.policy", TopicConfig.CLEANUP_POLICY_COMPACT)
        p.put("segment.ms", "0")
		p.put("log.retention.hours", Int.MAX_VALUE.toString())

        p.put("schema.registry.url", System.getenv("SCHEMA_REGISTRY") ?: "http://127.0.0.1:29092")
        p
    }()


    val builder = StreamsBuilder()

    val matrix: Array<Array<Long>> = Array(max1.toInt()) { Array(max0.toInt()) { 0L } }
    println(Pair(max0, max1))

    val lastSeenStream = builder.table<String, String>("lastSeen")
    val balanceStream = builder.table<String, String>("balance")

    val result = lastSeenStream.join(balanceStream) { lastSeenString, balanceString ->

        val lastSeen = lastSeenString.toLong()
        val balance = (BigInteger(balanceString) / BigInteger("1000000000000000000")).longValueExact()

        val lastSeenIndex = Math.log10(lastSeen.toDouble()) / Math.log10(1.2)
        val balanceIndex =  Math.log10(balance.toDouble()) / Math.log10(1.2)
        println(Pair(lastSeenIndex, balanceIndex))

        Pair(Math.min(lastSeenIndex.roundToLong(), max1 - 1), Math.min(balanceIndex.roundToLong(), max0 - 1))
    }.toStream().groupByKey()
            .aggregate({ ObjectMapper().writeValueAsString( listOf(-1L, -1L) ) }, { key, value, pString ->
                val previous = ObjectMapper().readValue(pString, List(0, { 0L }).javaClass)

                if(previous[0] >= 0 || previous[1] >= 0) {
                    matrix[previous[0].toInt()][previous[1].toInt()]--
                }
                matrix[value.first.toInt()][value.second.toInt()]++
                ObjectMapper().writeValueAsString(value.toList())
            }, Materialized.`as`("distribution")).toStream()

    result.map { x, y ->
        KeyValue(x ,ObjectMapper().writeValueAsString(matrix))
    }.to("distribution-bls")
    result.to("distribution")

    val streams = KafkaStreams(builder.build(), config)

    streams.cleanUp()
    streams.start()
    println("starting")
}
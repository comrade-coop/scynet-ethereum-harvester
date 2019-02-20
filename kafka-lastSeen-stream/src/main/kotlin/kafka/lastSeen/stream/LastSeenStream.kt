package kafka.lastSeen.stream

import kafka.lastSeen.stream.messages.Messages.Block
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed
import java.util.*
import kafka.lastSeen.stream.serialization.BlockSerdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.KeyValue
import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.streams.kstream.Materialized
import kotlin.collections.ArrayList


fun main(args: Array<String>) {
    LastSeenStream().start()
}

class LastSeenStream {
    public fun start()
    {
        val properties = Properties().apply {
            setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:29092")
            setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "lastSeen")
            setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
            setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
        }
        val builder = StreamsBuilder()

        val blockStream = builder.stream<String, Block>("test3", Consumed.with(Serdes.String(), BlockSerdes()))

        val groupedByAddressTimestamp = blockStream.flatMap { _, block ->
            val traces = block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
            var addresses = ArrayList<String>()
            traces.map { trace ->
                when(trace.type){
                    "reward" -> addresses.add(trace.reward.author)
                    "call" -> addresses.addAll(listOf<String>(trace.call.from, trace.call.to))
                    "suicide" -> addresses.add(trace.suicide.refundAddress)
                    "create" -> addresses.add(trace.create.from)
                    else -> null
                }
            }
            addresses.map { address -> KeyValue(address,block.timestamp) }
        }.groupBy { address, timestamp -> address }
            .aggregate(
            { "" },
            { address, timestamp, previousTimestamp -> timestamp  },
            Materialized.`as`("lastSeen")
        ).toStream().to("lastSeen")

        val lastSeenStream = KafkaStreams(builder.build(), properties)
        lastSeenStream.start()
    }
}


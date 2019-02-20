package kafka.balance.stream

import kafka.balance.stream.serialization.BlockSerdes
import  kafka.balance.stream.messages.Messages.Block
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.KeyValue
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.streams.kstream.Consumed
import org.apache.kafka.streams.kstream.Materialized
import java.math.BigInteger
import java.util.*

fun main(args: Array<String>) {
    BalanceStream("127.0.0.1:29092").start()
}

class BalanceStream(private val broker: String){
    fun start(){

        val properties = Properties().apply {
            setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, broker)
            setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "balance")
            setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
            setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
        }
        val builder = StreamsBuilder()

        val blockStream = builder.stream<String, Block>("test3", Consumed.with(Serdes.String(), BlockSerdes()))

        val groupedByAddressTimestamp = blockStream.flatMap { _, block ->
            val traces = block.transactionsList
                    .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
            val addresses = ArrayList<KeyValue<String, String>>()
            traces.map { trace ->
                when(trace.type){
                    "reward" -> addresses.add(KeyValue(trace.reward.author, trace.reward.value))
                    "call" -> addresses.addAll(listOf(KeyValue(trace.call.from, trace.call.value), KeyValue(trace.call.to, trace.call.value)))
                    "suicide" -> addresses.add(KeyValue(trace.suicide.refundAddress, trace.suicide.balance))
                    "create" -> addresses.add(KeyValue(trace.create.from, trace.create.value))
                    else -> null
                }
            }
            addresses.map { KV -> KV }
        }.groupBy { address, balance -> address }
                .aggregate(
                        { BigInteger.ZERO.toString() },
                        { address, balance, previousBalance -> sum(balance,previousBalance)  },
                        Materialized.`as`("balance")
                ).toStream().to("balance")

        val balanceStream = KafkaStreams(builder.build(), properties)
        balanceStream.start()
    }

    private  fun sum(balance: String, previousBalance: String) : String{
        var result = BigInteger(balance) + BigInteger(previousBalance)
        if(result < BigInteger.ZERO){
            result = BigInteger.ZERO
        }
        return result.toString()
    }
}

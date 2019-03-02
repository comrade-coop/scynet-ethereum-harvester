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
    BalanceStream("127.0.0.1:9092").start()
}

class BalanceStream(private val broker: String) {
    fun start() {

        val properties = Properties().apply {
            setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, broker)
            setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "balance")
            setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
            setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
        }
        val builder = StreamsBuilder()

        val blockStream = builder.stream<String, Block>("ethereum_blocks", Consumed.with(Serdes.String(), BlockSerdes()))
        blockStream.flatMap { _, block ->

            val addressBalance = ArrayList<KeyValue<String, String>>()
            accountForGas(block, addressBalance)

            val traces = block.transactionsList
                    .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
            traces.forEach { trace ->
                when (trace.type) {
                    "reward" -> addressBalance.add(KeyValue(trace.reward.author, trace.reward.value))
                    "call" -> addressBalance.addAll(listOf(KeyValue(trace.call.from, "-" + trace.call.value), KeyValue(trace.call.to, trace.call.value)))
                    "suicide" -> addressBalance.add(KeyValue(trace.suicide.refundAddress, trace.suicide.balance))
                    "create" -> addressBalance.add(KeyValue(trace.create.from, trace.create.value))
                }
            }
            addressBalance
        }.groupBy { address, balance -> address }
                .aggregate(
                        { BigInteger.ZERO.toString() },
                        { address, balance, previousBalance -> sum(balance, previousBalance) },
                        Materialized.`as`("balance")
                ).toStream().to("balance")

        val balanceStream = KafkaStreams(builder.build(), properties)
        balanceStream.start()
    }

    private fun accountForGas(block: Block, addressBalance: ArrayList<KeyValue<String, String>>) {

        var rewardForBlockAuthor = BigInteger.ZERO
        block.transactionsList.map { transaction ->
            addressBalance.add(KeyValue(transaction.from, "-" + multiplyGasByPrice(transaction.gas, transaction.gasPrice).toString()))
            rewardForBlockAuthor += multiplyGasByPrice(transaction.gas, transaction.gasPrice)
        }
        addressBalance.add(KeyValue(block.author, rewardForBlockAuthor.toString()))
    }

    private fun sum(balance: String, previousBalance: String): String {
        var result = BigInteger(balance) + BigInteger(previousBalance)
        if (result < BigInteger.ZERO) {
            result = BigInteger.ZERO
        }
        return result.toString()
    }

    private fun multiplyGasByPrice(gas: String, gasPrice: String): BigInteger {
        return BigInteger(gas) * BigInteger(gasPrice)
    }
}

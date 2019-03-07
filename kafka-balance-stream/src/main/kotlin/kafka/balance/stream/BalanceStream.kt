package kafka.balance.stream

import kafka.balance.stream.messages.Messages.Block
import kafka.balance.stream.serialization.BlockSerdes
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.*
import org.apache.kafka.streams.kstream.Consumed
import org.apache.kafka.streams.kstream.KGroupedStream
import org.apache.kafka.streams.kstream.KStream
import org.apache.kafka.streams.kstream.Materialized
import java.math.BigInteger
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val streamBuilder = StreamsBuilder()

    val properties = Properties().apply {
        setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092")
        setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "balance")
        setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
        setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
    }
    BalanceStream(streamBuilder, properties).start()
}


class BalanceStream(private val streamBuilder: StreamsBuilder,
                    private val properties: Properties) {
    fun start() {
        val balanceStream = KafkaStreams(getTopology(), properties)
        balanceStream.start()
    }

    fun getTopology(): Topology {
        val blockStream = streamBuilder.stream<String, Block>("ethereum_blocks", Consumed.with(Serdes.String(), BlockSerdes()))
        val groupedBalancesByAddress = groupBalancesByAddress(blockStream)
        aggregate(groupedBalancesByAddress)
        return streamBuilder.build()
    }

    private fun groupBalancesByAddress(blockStream: KStream<String, Block>): KGroupedStream<String, String> {
        return blockStream.flatMap { _, block ->
            val addressBalanceList = ArrayList<KeyValue<String, String>>()
            addAddressBalanceFromGas(block, addressBalanceList)
            addAddressBalanceFromTraces(block, addressBalanceList)
            addressBalanceList
        }.groupBy { address, balance -> address }
    }

    private fun addAddressBalanceFromGas(block: Block, addressBalanceList: ArrayList<KeyValue<String, String>>) {
        var rewardForBlockAuthor = BigInteger.ZERO

        block.transactionsList.forEach { transaction ->
            addressBalanceList.add(KeyValue(transaction.from, "-" + multiplyGasByPrice(transaction.gas, transaction.gasPrice).toString()))
            rewardForBlockAuthor = rewardForBlockAuthor.add(multiplyGasByPrice(transaction.gas, transaction.gasPrice))
        }
        addressBalanceList.add(KeyValue(block.author, rewardForBlockAuthor.toString()))
    }

    private fun aggregate(groupedBalancesByAddress: KGroupedStream<String, String>) {
        return groupedBalancesByAddress
                .aggregate(
                        { BigInteger.ZERO.toString() },
                        { address, balance, previousBalance -> sum(balance, previousBalance) },
                        Materialized.`as`("balance")
                )
                .toStream()
                .to("balance")
    }

    private fun sum(balance: String, previousBalance: String): String {
        var result = BigInteger(balance).add(BigInteger(previousBalance))
        // TODO uncomment when starting from block 0
//        if(result < BigInteger.ZERO){
//            result = BigInteger.ZERO
//        }
        return result.toString()
    }

    private fun multiplyGasByPrice(gas: String, gasPrice: String): BigInteger {
        return BigInteger(gas).multiply(BigInteger(gasPrice))
    }

    private fun addAddressBalanceFromTraces(block: Block, addressBalanceList: ArrayList<KeyValue<String, String>>) {
        val traces = block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
        traces.forEach { trace ->
            when (trace.type) {
                "reward" -> addressBalanceList.add(KeyValue(trace.reward.author, trace.reward.value))
                "call" -> addressBalanceList.addAll(listOf(KeyValue(trace.call.from, "-" + trace.call.value), KeyValue(trace.call.to, trace.call.value)))
                "suicide" -> addressBalanceList.add(KeyValue(trace.suicide.refundAddress, trace.suicide.balance))
                "create" -> addressBalanceList.add(KeyValue(trace.create.from, trace.create.value))
            }
        }
    }
}

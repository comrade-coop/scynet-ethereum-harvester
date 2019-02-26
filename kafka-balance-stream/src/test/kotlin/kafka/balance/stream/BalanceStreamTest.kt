package kafka.balance.stream


import org.apache.kafka.common.serialization.IntegerDeserializer
import org.apache.kafka.common.serialization.IntegerSerializer
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.streams.TopologyTestDriver
import org.apache.kafka.streams.kstream.Materialized
import org.apache.kafka.streams.test.ConsumerRecordFactory
import org.apache.kafka.streams.test.OutputVerifier
import java.math.BigInteger
import java.util.*
import kotlin.test.Test


class BalanceStreamTest {

    @Test
    fun testAggregation() {
        val builder = StreamsBuilder();
        builder.stream<Int, Int>("input-topic")
                .groupBy{ address, balance -> address}
                .aggregate(
                        { 0 },
                        { address, balance, previousBalance ->  balance + previousBalance },
                        Materialized.`as`("balance")

                ) to "output-topic"
        val topology = builder.build();

        val props = Properties()
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Integer().javaClass.getName())
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.Integer().javaClass.getName())
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "test")
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dummy:1234")

        val testDriver = TopologyTestDriver(topology, props)
        val factory = ConsumerRecordFactory<Int, Int>("input-topic",IntegerSerializer(), IntegerSerializer())

        testDriver.pipeInput(factory.create( Integer.valueOf(101), Integer.valueOf(101)))
        testDriver.pipeInput(factory.create( Integer.valueOf(101), Integer.valueOf(101)))
        testDriver.pipeInput(factory.create( Integer.valueOf(101), Integer.valueOf(101)))

        val outputRecord = testDriver.readOutput("output-topic", IntegerDeserializer(), IntegerDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, 101, 303)
        testDriver.close();
    }


    private fun sum(balance: String, previousBalance: String): String {
        var result = BigInteger(balance) + BigInteger(previousBalance)
        if (result < BigInteger.ZERO) {
            result = BigInteger.ZERO
        }
        return result.toString()
    }
}
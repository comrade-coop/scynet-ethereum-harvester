package kafka.balance.stream

import org.apache.kafka.common.serialization.*
import kotlin.test.Test
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Materialized
import java.math.BigInteger
import java.util.*
import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.streams.TopologyTestDriver
import org.apache.kafka.streams.test.ConsumerRecordFactory
import org.apache.kafka.streams.test.OutputVerifier
import org.junit.After
import org.junit.Before

class BalanceStreamTest {

    private var testDriver: TopologyTestDriver? = null
    private val factory = ConsumerRecordFactory<Int, Int>("input-topic",IntegerSerializer(), IntegerSerializer())

    @Before
    fun setup() {
        val builder = StreamsBuilder();
        builder.stream<Int, Int>("input-topic")
                .groupBy{ address, balance -> address}
                .aggregate(
                        { 0 },
                        { address, balance, previousBalance ->  balance + previousBalance },
                        Materialized.`as`("balance")

                ).toStream().to("output-topic");
        val topology = builder.build();
        val config = Properties().apply {
            setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "test")
            setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dummy:1234")
            setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Integer().javaClass.name)
            setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.Integer().javaClass.name)

        }
        testDriver = TopologyTestDriver(topology, config)
    }
    @After
    fun tearDown() {
        testDriver?.close()
    }


    @Test
    fun testAggregation() {
        testDriver?.pipeInput(factory.create( Integer.valueOf(104), Integer.valueOf(101)))
        val outputRecord1 = testDriver?.readOutput("output-topic", IntegerDeserializer(), IntegerDeserializer())
        testDriver?.pipeInput(factory.create( Integer.valueOf(104), Integer.valueOf(101)))
        val outputRecord2 = testDriver?.readOutput("output-topic", IntegerDeserializer(), IntegerDeserializer())
        OutputVerifier.compareKeyValue(outputRecord1, 104, 101)
        OutputVerifier.compareKeyValue(outputRecord2, 104, 202)
    }

    private fun sum(balance: String, previousBalance: String): String {
        var result = BigInteger(balance) + BigInteger(previousBalance)
        if (result < BigInteger.ZERO) {
            result = BigInteger.ZERO
        }
        return result.toString()
    }
}
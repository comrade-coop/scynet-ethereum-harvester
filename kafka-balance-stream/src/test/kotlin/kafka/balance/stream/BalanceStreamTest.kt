package kafka.balance.stream


import org.apache.kafka.clients.consumer.ConsumerRecord
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

                ).to("output-topic");
        val topology = builder.build();
        val config = Properties().apply {
            setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "test")
            setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dummy:1234")

        }
        var testDriver = TopologyTestDriver(topology, config)
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
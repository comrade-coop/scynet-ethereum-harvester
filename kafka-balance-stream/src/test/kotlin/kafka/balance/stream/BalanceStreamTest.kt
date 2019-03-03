package kafka.balance.stream

import kafka.balance.stream.messages.Messages
import kafka.balance.stream.serialization.BlockSerializer
import org.apache.kafka.common.serialization.*
import kotlin.test.Test
import org.apache.kafka.streams.StreamsBuilder
import java.util.*
import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.streams.TopologyTestDriver
import org.apache.kafka.streams.test.ConsumerRecordFactory
import org.apache.kafka.streams.test.OutputVerifier
import org.junit.After
import org.junit.Before
import kafka.balance.stream.block.mock.getMockedBlock

class BalanceStreamTest {

    private var testDriver: TopologyTestDriver? = null
    private val factory = ConsumerRecordFactory<Int, Messages.Block>("ethereum_blocks",IntegerSerializer(), BlockSerializer())


    @Before
    fun setup() {
        val properties = Properties().apply {
            setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "test")
            setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dummy:1234")
            setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
            setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
        }
        val builder = StreamsBuilder()
        val topology = BalanceStream(builder, properties).getTopology()
        testDriver = TopologyTestDriver(topology, properties)
    }
    @After
    fun tearDown() {
        testDriver?.close()
    }

    @Test
    fun testAggregationWithMockedBlcok(){
        val blocks = getMockedBlock(1, 2, 3)
        for(block: Messages.Block in blocks){
            testDriver?.pipeInput(factory.create(0, block))
        }
        var outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "transaction_sender", "-2")

        outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "transaction_sender", "-4")

        outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "block_author", "4")

        outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "trace_sender", "-1")

        outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "trace_receiver", "1")

        outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "trace_sender", "-3")

        outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "trace_receiver", "3")

        outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "trace_sender", "-6")

        outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "trace_receiver", "6")


        outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "trace_sender", "-10")
    }

    @Test
    fun testAggregationWitTwoBlocks(){
        val blocks = getMockedBlock(2,1,1)
        for(block: Messages.Block in blocks){
            testDriver?.pipeInput(factory.create(0, block))
        }
        var outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "transaction_sender", "-2")

        outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "block_author", "2")

        outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "trace_sender", "-1")

        outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "trace_receiver", "1")

        outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "transaction_sender", "-4")

        outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "block_author", "4")

        outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "trace_sender", "-2")

        outputRecord = testDriver?.readOutput("balance", StringDeserializer(), StringDeserializer())
        OutputVerifier.compareKeyValue(outputRecord, "trace_receiver", "2")

    }

}

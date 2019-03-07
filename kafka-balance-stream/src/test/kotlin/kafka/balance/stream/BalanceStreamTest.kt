package kafka.balance.stream

import kafka.balance.stream.messages.Messages
import kafka.balance.stream.block.mock.getMockedBlock
import kafka.balance.stream.serialization.*
import org.apache.kafka.common.serialization.*
import kotlin.test.Test
import java.util.*
import org.apache.kafka.streams.test.ConsumerRecordFactory
import org.apache.kafka.streams.test.OutputVerifier
import org.junit.After
import org.junit.Before
import org.apache.kafka.streams.*
import org.junit.Assert
import kotlin.collections.HashMap

class BalanceStreamTest {

    private var testDriver: TopologyTestDriver? = null
    private val factory = ConsumerRecordFactory<String, Messages.Block>("ethereum_blocks",StringSerializer(), BlockSerializer())

    @Before
    fun setup() {
        val properties = Properties().apply {
            setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "test")
            setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dummy:1234")
            setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
            setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, AddressFeatureSerdes().javaClass.name)
        }

        val topology = BalanceStream().getTopology()

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
                testDriver?.pipeInput(factory.create("ethereum_blocks", "0",  block))
        }
        var outputRecord = testDriver?.readOutput("balance", StringDeserializer(), AddressBalanceMapDeserializer())
        val correctOutputMap = HashMap<String, String>()
        correctOutputMap.put("transaction_sender", "-4")
        correctOutputMap.put("trace_sender", "-21")
        correctOutputMap.put("trace_receiver", "21")
        correctOutputMap.put("block_author", "4")
        val correctOutput = AddressBalance.AddressBalanceMap.newBuilder().putAllAddressBalance(correctOutputMap).build()
        OutputVerifier.compareKeyValue(outputRecord, "0", correctOutput)

        Assert.assertNull(testDriver?.readOutput("balance", StringDeserializer(), AddressBalanceMapDeserializer()))
    }

    @Test
    fun testAggregationWitTwoBlocks(){
        val blocks = getMockedBlock(2,1,1)
        for(block: Messages.Block in blocks){
            testDriver?.pipeInput(factory.create("ethereum_blocks","0", block))
        }

        var outputRecord = testDriver?.readOutput("balance", StringDeserializer(), AddressBalanceMapDeserializer())
        val correctOutputMap = HashMap<String, String>()
        correctOutputMap.put("transaction_sender", "-2")
        correctOutputMap.put("trace_sender", "-1")
        correctOutputMap.put("trace_receiver", "1")
        correctOutputMap.put("block_author", "2")
        var correctOutput = AddressBalance.AddressBalanceMap.newBuilder().putAllAddressBalance(correctOutputMap).build()
        OutputVerifier.compareKeyValue(outputRecord, "0", correctOutput)

        outputRecord = testDriver?.readOutput("balance", StringDeserializer(), AddressBalanceMapDeserializer())
        correctOutputMap.put("transaction_sender", "-4")
        correctOutputMap.put("trace_sender", "-2")
        correctOutputMap.put("trace_receiver", "2")
        correctOutputMap.put("block_author", "4")
        correctOutput = AddressBalance.AddressBalanceMap.newBuilder().putAllAddressBalance(correctOutputMap).build()
        OutputVerifier.compareKeyValue(outputRecord, "0", correctOutput)

        Assert.assertNull(testDriver?.readOutput("balance", StringDeserializer(), AddressBalanceMapDeserializer()))
    }

}

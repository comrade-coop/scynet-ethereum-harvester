package kafka.balance.stream

import kafka.balance.stream.serialization.BlockSerdes
import  kafka.balance.stream.messages.Messages.Block
import kafka.balance.stream.serialization.AddressBalanceSerdes
import kafka.balance.stream.serialization.BlockDeserializer
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*
import org.apache.kafka.streams.kstream.*
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorSupplier
import org.apache.kafka.streams.state.Stores
import java.math.BigInteger
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val streamBuilder = StreamsBuilder()
    
    val properties = Properties().apply {
        setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092")
        setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "balance")
        setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
        setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, AddressBalanceSerdes().javaClass.name)
    }
    BalanceStream(streamBuilder, properties).start()
}


class BalanceStream(private val streamBuilder: StreamsBuilder,
                    private val properties: Properties){
    fun start(){
        val balanceStream = KafkaStreams(getTopology(), properties)
        balanceStream.start()
    }
    fun getTopology(): Topology{

        val addressBalanceStoreSupplier = Stores.keyValueStoreBuilder(
                Stores.persistentKeyValueStore("AccountBalance"),
                Serdes.String(),
                Serdes.String()
        ).withLoggingDisabled() //enable in production
        val builder = Topology()

        builder.addSource("Source", "ethereum_blocks", StringDeserializer().javaClass.name, BlockDeserializer().javaClass.name)
               .addProcessor("Process", Supplier(), "Source")
               .addStateStore(addressBalanceStoreSupplier, "Process")
               .addSink("Sink", "balance", "Process")

              //  .addProcessor("Process", ProcessorSupplier<String, String>{()-> AddressBalanceProcessor()}, "Source")
//        val blockStream = streamBuilder.stream<String, Block>("ethereum_blocks", Consumed.with(Serdes.String(), BlockSerdes()))
//        val groupedBalancesByAddress = groupBalancesByAddress(blockStream)
//        val aggregated = aggregate(groupedBalancesByAddress)
//        val topology = streamBuilder.build()
//        return topology
        return builder
    }
}

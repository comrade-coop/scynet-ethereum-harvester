package kafka.transactionsNumber.stream

import kafka.transactionsNumber.stream.config.StreamConfig
import kafka.transactionsNumber.stream.serialization.BlockDeserializer
import kafka.transactionsNumber.stream.processor.TransactionsNumberProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*

fun main(args: Array<String>) {
    VolumeOutStream().start()
}

class VolumeOutStream(){
    fun start(){
        val volumeOutStream = KafkaStreams(getTopology(), StreamConfig.getStreamProperties())
        volumeOutStream.cleanUp()
        volumeOutStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(volumeOutStream::close));
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")

                .addProcessor("Processor", TransactionsNumberProcessorSupplier(), "Ethereum-producer")
                .addStateStore(StreamConfig.getAddressTransactionsNumberStoreSupplier(), "Processor")
                .addStateStore(StreamConfig.getBlockAddressTransactionsNumberSupplier(), "Processor")
                .addStateStore(StreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("VolumeOut-stream", "transactionsNumber", "Processor")
        return topology
    }
}

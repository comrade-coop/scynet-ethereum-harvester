package kafka.transferLogsCount.stream

import kafka.transferLogsCount.stream.config.StreamConfig
import kafka.transferLogsCount.stream.serialization.BlockDeserializer
import kafka.transferLogsCount.stream.processor.TransferLogsCountProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*

fun main(args: Array<String>) {
    TransferLogsCountStream().start()
}

class TransferLogsCountStream(){
    fun start(){
        val transferLogsCountStream = KafkaStreams(getTopology(), StreamConfig.getStreamProperties())
        transferLogsCountStream.cleanUp()
        transferLogsCountStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(transferLogsCountStream::close))
    }

    private fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")

                .addProcessor("Processor", TransferLogsCountProcessorSupplier(), "Ethereum-producer")
                .addStateStore(StreamConfig.getAddressTransferLogsCountStoreSupplier(), "Processor")
                .addStateStore(StreamConfig.getBlockAddressTransferLogsCountSupplier(), "Processor")
                .addStateStore(StreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("TransferLogsCount-stream", "transferLogsCount", "Processor")
        return topology
    }
}

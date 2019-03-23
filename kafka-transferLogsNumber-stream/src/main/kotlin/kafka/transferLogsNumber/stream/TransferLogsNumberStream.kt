package kafka.transferLogsNumber.stream

import kafka.transferLogsNumber.stream.config.StreamConfig
import kafka.transferLogsNumber.stream.serialization.BlockDeserializer
import kafka.transferLogsNumber.stream.processor.TransferLogsNumberProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*

fun main(args: Array<String>) {
    TransferLogsNumberStream().start()
}

class TransferLogsNumberStream(){
    fun start(){
        val transferLogsNumberStream = KafkaStreams(getTopology(), StreamConfig.getStreamProperties())
        transferLogsNumberStream.cleanUp()
        transferLogsNumberStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(transferLogsNumberStream::close));
    }

    private fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")

                .addProcessor("Processor", TransferLogsNumberProcessorSupplier(), "Ethereum-producer")
                .addStateStore(StreamConfig.getAddressTransferLogsNumberStoreSupplier(), "Processor")
                .addStateStore(StreamConfig.getBlockAddressTransferLogsNumberSupplier(), "Processor")
                .addStateStore(StreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("TransferLogsNumber-stream", "transferLogsNumber", "Processor")
        return topology
    }
}

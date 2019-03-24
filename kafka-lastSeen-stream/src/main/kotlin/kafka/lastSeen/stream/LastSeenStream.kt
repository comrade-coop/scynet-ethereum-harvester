package kafka.lastSeen.stream

import harvester.common.serialization.BlockDeserializer
import kafka.lastSeen.stream.config.StreamConfig
import kafka.lastSeen.stream.processor.LastSeenProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*

fun main(args: Array<String>) {
    LastSeenStream().start()
}

class LastSeenStream {
    fun start(){
        val lastSeenStream = KafkaStreams(getTopology(), StreamConfig.getLasSeenStreamProperties())
        lastSeenStream.cleanUp()
        lastSeenStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(lastSeenStream::close))
    }

    fun getTopology():Topology{
        val topology = Topology()
                .addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")
                .addProcessor("Processor", LastSeenProcessorSupplier(), "Ethereum-producer")
                .addStateStore(StreamConfig.getLastSeenStoreSupplier(), "Processor")
                .addSink("LastSeen-stream", "lastSeen", "Processor")
        return topology
    }
}


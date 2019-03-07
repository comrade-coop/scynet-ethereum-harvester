package kafka.lastSeen.stream

import kafka.lastSeen.stream.serialization.BlockDeserializer
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
                .addSource("Blockchain-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")
                .addProcessor("Processor", LastSeenProcessorSupplier(), "Blockchain-producer")
                .addStateStore(StreamConfig.getLastSeenStoreSupplier(), "Processor")
                .addSink("LastSeen-stream", "lastSeen", "Processor")
        return topology
    }
}


package kafka.gasPrice.stream

import harvester.common.config.StreamConfig
import harvester.common.serialization.BlockDeserializer
import kafka.gasPrice.stream.processor.GasPriceProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology

fun main() {
    GasPriceStream().start()
}

class GasPriceStream(){
    fun start(){
        val gasPriceStream =
                KafkaStreams(getTopology(), StreamConfig.getStreamProperties("127.0.0.1:29092", "gasPrice"))
        gasPriceStream.cleanUp()
        gasPriceStream.start()
        Runtime.getRuntime().addShutdownHook(Thread(gasPriceStream::close))
    }

    fun getTopology(): Topology{
        val topology = Topology()
        topology.addSource("Ethereum-producer", StringDeserializer(), BlockDeserializer(), "ethereum_blocks")
                .addProcessor("Processor", GasPriceProcessorSupplier(), "Ethereum-producer")
                .addStateStore(StreamConfig.getSynchronizationStoreSupplier(), "Processor")
                .addSink("GasPrice-stream", "gasPrice", "Processor")
        return topology
    }
}

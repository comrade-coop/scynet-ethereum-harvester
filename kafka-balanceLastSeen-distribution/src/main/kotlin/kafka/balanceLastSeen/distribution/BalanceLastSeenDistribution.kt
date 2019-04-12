package kafka.balanceLastSeen.distribution

import harvester.common.serialization.JoinDeserializer
import kafka.balanceLastSeen.distribution.config.StreamConfig
import java.math.BigInteger
import kotlin.math.roundToInt
import kafka.balanceLastSeen.distribution.processor.DistributionProcessorSupplier
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*
import java.io.FileOutputStream


fun main(args: Array<String>) {
    JoinerStream().start()
    BalanceLastSeenDistribution().start()
}

class BalanceLastSeenDistribution{

    private val maxBalance = (Math.log10(10000000.0) / Math.log10(1.2)).roundToInt()
    private val maxLastSeen = (Math.log10(20736000.0) / Math.log10(1.2)).roundToInt()
    private val divideWeiToGetTenthOfEthereum = BigInteger.valueOf(100000000000000000)
    private val file: FileOutputStream = FileOutputStream("distributions", true)
    fun start(){
        val balanceLastSeenDistribution = KafkaStreams(getTopology(), StreamConfig.getStreamProperties())
        balanceLastSeenDistribution.cleanUp()
        balanceLastSeenDistribution.start()

        Runtime.getRuntime().addShutdownHook(Thread(balanceLastSeenDistribution::close))
        Runtime.getRuntime().addShutdownHook(Thread() {
            fun run(){
                file.close()
            }
        })
    }

    private fun getTopology(): Topology {
        val topology = Topology()
                .addSource("Feature-Joiner", StringDeserializer(), JoinDeserializer(), "BalanceLastSeen")
                .addProcessor("Processor", DistributionProcessorSupplier(), "Feature-Joiner")
                .addStateStore(StreamConfig.getMatrixStoreSupplier(), "Processor")
                .addStateStore(StreamConfig.getAddressPositionStoreSupplier(), "Processor")
                .addSink("Distribution-BalanceLastSeen", "distribution-balanceLastSeen", "Processor")
        return topology
    }
}
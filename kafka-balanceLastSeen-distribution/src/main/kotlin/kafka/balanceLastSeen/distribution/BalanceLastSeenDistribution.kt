package kafka.balanceLastSeen.distribution

import kafka.balanceLastSeen.distribution.config.StreamConfig
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.kstream.Consumed
import java.math.BigInteger
import kotlin.math.roundToInt
import kafka.balanceLastSeen.distribution.messages.MatrixBlob
import kafka.balanceLastSeen.distribution.messages.StreamJoin
import kafka.balanceLastSeen.distribution.processor.DistributionProcessorSupplier
import kafka.balanceLastSeen.distribution.serialization.JoinDeserializer
import kafka.balanceLastSeen.distribution.serialization.JoinSerdes
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.*
import java.io.FileOutputStream


fun main(args: Array<String>) {
    StreamJoiner().start()
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
                //.addStateStore(StreamConfig.getSortedAddressesByBlockStoreSupplier(), "Processor")
                .addSink("Distribution-BalanceLastSeen", "distribution-balanceLastSeen", "Processor")
        return topology
//
//        val builder = StreamsBuilder()
//
//       val balanceLastSeen = builder.stream<String, StreamJoin.Join>("BalanceLastSeen", Consumed.with(Serdes.String(), JoinSerdes()))
//
//        balanceLastSeen.map { blockNumber, joined ->
//
//            val balances = joined.featureMap1Map
//            val lastSeen = joined.featureMap2Map
//            if(balances.count() != lastSeen.count()){
//                println()
//            }
//            //  represented as matrix[lastSeen][balance]
//            val matrix: Array<Array<Long>> = Array(maxLastSeen) { Array(maxBalance) { 0L } }
//
//            lastSeen.forEach { addressLastSeenEntry ->
//
//                val lastSeenGroup = Math.min((scaleDown(addressLastSeenEntry.value.toDouble())), maxLastSeen - 1)
//                var balance = balances.get(addressLastSeenEntry.key)
//                val weiBalance  = weiToTenthOfEth(balance)
//                if (weiBalance <= 0) {
//                    return@forEach
//                }
//                val balanceGroup = Math.min(scaleDown(weiBalance.toDouble()), maxBalance - 1)
//
//                matrix[lastSeenGroup][balanceGroup]++
//            }
//            val blob = buildBlob(matrix)
//            println(blockNumber)
//            KeyValue(blockNumber, blob)
//        }.to("distribution-balanceLastSeen")
//        }.toStream().map { blockNumber, distributionMatrix ->
//            println(blockNumber)
//            val blob = buildBlob(distributionMatrix)
////            if(blockNumber.toInt() % 1000 == 0){
////                blob.writeDelimitedTo(file)
////            }
//            KeyValue(blockNumber, blob)
//        }.to("distribution-balanceLastSeen")

    }

    private fun scaleDown(value: Double): Int{
        if(value < 1){
            return  0
        }
        return (Math.log10(value)/Math.log10(1.2)).roundToInt()
    }

    private fun weiToTenthOfEth(balance: String?): Long{
       return (balance!!.toBigInteger() / divideWeiToGetTenthOfEthereum).toLong()
    }

    private fun buildBlob(distributionMatrix: Array<Array<Long>>): MatrixBlob.Blob{
        val blobBuilder = MatrixBlob.Blob.newBuilder()
        val shape = MatrixBlob.Shape.newBuilder()
                .addDimension(maxBalance)
                .addDimension( maxLastSeen)
                .build()
        blobBuilder.setShape(shape)
        for (balanceGroup in 0..(maxBalance - 1)){
            for (lastSeenGroup in 0..(maxLastSeen - 1)){
                blobBuilder.addData(distributionMatrix[lastSeenGroup][balanceGroup].toFloat())
            }
        }
        return blobBuilder.build()
    }
}
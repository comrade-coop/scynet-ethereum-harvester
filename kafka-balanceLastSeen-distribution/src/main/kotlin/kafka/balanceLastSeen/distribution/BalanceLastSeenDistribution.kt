package kafka.balanceLastSeen.distribution

import com.fasterxml.jackson.databind.ObjectMapper
import kafka.balanceLastSeen.distribution.config.StreamConfig
import kafka.balanceLastSeen.distribution.serialization.AddressFeatureSerdes
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.kstream.Consumed
import java.math.BigInteger
import kotlin.math.roundToInt
import kafka.balanceLastSeen.distribution.messages.AddressFeature
import org.apache.kafka.streams.*


fun main(args: Array<String>) {
    BalanceLastSeenDistribution().start()
}

class BalanceLastSeenDistribution{

    private val maxBalance = (Math.log10(10000000.0) / Math.log10(1.2)).roundToInt()
    private val maxLastSeen = (Math.log10(20736000.0) / Math.log10(1.2)).roundToInt()
    private val divideWeiToGetTenthOfEthereum = BigInteger.valueOf(100000000000000000)

    fun start(){
        val balanceLastSeenDistribution = KafkaStreams(getTopology(), StreamConfig.getStreamProperties())
        balanceLastSeenDistribution.cleanUp()
        balanceLastSeenDistribution.start()
        Runtime.getRuntime().addShutdownHook(Thread(balanceLastSeenDistribution::close))
    }

    private fun getTopology(): Topology {

        val builder = StreamsBuilder()

        val lastSeenStream = builder.table<String, AddressFeature.AddressFeatureMap>("lastSeen", Consumed.with(Serdes.String(), AddressFeatureSerdes()))
        val balanceStream = builder.table<String, AddressFeature.AddressFeatureMap>("balance", Consumed.with(Serdes.String(), AddressFeatureSerdes()))

        lastSeenStream.join(balanceStream) { addressLastSeenMap, addressBalanceMap ->
            //  represented as matrix[lastSeen][balance]
            val matrix: Array<Array<Long>> = Array(maxLastSeen) { Array(maxBalance) { 0L } }

            addressLastSeenMap.addressFeatureMap.forEach{ addressLastSeenEntry ->

                val lastSeenGroup = Math.min((scaleDown(addressLastSeenEntry.value.toDouble())) , maxLastSeen - 1)
                var balance = weiToTenthOfEth(addressBalanceMap.getAddressFeatureOrThrow(addressLastSeenEntry.key))
                val balanceGroup = Math.min(scaleDown(balance.toDouble()), maxBalance - 1)

                matrix[lastSeenGroup][balanceGroup]++
            }
            matrix
        }.toStream().map { blockNumber, distributionMatrix ->
            KeyValue(blockNumber, ObjectMapper().writeValueAsString(distributionMatrix))
        }.to("distribution-balanceLastSeen")

        return builder.build()
    }

    private fun scaleDown(value: Double): Int{
        if(value < 1){
            return  0
        }
        return (Math.log10(value)/Math.log10(1.2)).roundToInt()
    }

    private fun weiToTenthOfEth(balance: String): Long{
       return (balance.toBigInteger() / divideWeiToGetTenthOfEthereum).toLong()
    }
}
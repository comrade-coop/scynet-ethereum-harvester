package harvester.common.processor

import java.math.BigInteger

class FeatureCalculator {
    companion object {

        fun sum(feature: String, previousFeature: String): String {
            val result = BigInteger(feature).add(BigInteger(previousFeature))
            // uncomment when starting from block 0
//          if(result < BigInteger.ZERO){
//            result = BigInteger.ZERO
//          }
            return result.toString()
        }

        fun increaseByOne(feature: String): String {
            return BigInteger(feature).add(BigInteger.ONE).toString()
        }

        fun subtract(previousFeature: String, feature: String): String {
            return BigInteger(previousFeature).subtract(BigInteger(feature)).toString()
        }
    }
}
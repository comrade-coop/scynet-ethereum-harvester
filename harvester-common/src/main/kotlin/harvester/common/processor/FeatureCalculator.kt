package harvester.common.processor

import java.math.BigInteger

class FeatureCalculator {
    companion object {

        fun sum(firstNum: String, secondNum: String): String {
            val result = BigInteger(firstNum).add(BigInteger(secondNum))
            // uncomment when starting from block 0
//          if(result < BigInteger.ZERO){
//            result = BigInteger.ZERO
//          }
            return result.toString()
        }

        fun increaseByOne(number: String): String {
            return BigInteger(number).add(BigInteger.ONE).toString()
        }

        fun subtract(firstNum: String, secondNum: String): String {
            return BigInteger(firstNum).subtract(BigInteger(secondNum)).toString()
        }

        fun multiply(firstNum: String, secondNum: String): String{
            return (BigInteger(firstNum) * BigInteger(secondNum)).toString()
        }
    }
}
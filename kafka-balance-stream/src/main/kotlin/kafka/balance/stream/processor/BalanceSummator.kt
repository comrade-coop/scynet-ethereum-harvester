package kafka.balance.stream.processor

import java.math.BigInteger

class BalanceSummator {
    companion object {
        fun sum(balance: String, previousBalance: String): String {
            var result = BigInteger(balance) + BigInteger(previousBalance)
            // uncomment when starting from block 0
//          if(result < BigInteger.ZERO){
//            result = BigInteger.ZERO
//          }
            return result.toString()
        }
    }
}
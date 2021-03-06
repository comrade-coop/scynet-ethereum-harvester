package kafka.balance.stream.processor

import java.math.BigInteger

class BalanceCalculator {
    companion object {
        fun sum(balance: String, previousBalance: String): String {
            var result = BigInteger(balance).add(BigInteger(previousBalance))
          if(result < BigInteger.ZERO){
            result = BigInteger.ZERO
          }
            return result.toString()
        }

        fun multiply(gas: String, gasPrice: String): String{
            return (BigInteger(gas) * BigInteger(gasPrice)).toString()
        }
    }
}
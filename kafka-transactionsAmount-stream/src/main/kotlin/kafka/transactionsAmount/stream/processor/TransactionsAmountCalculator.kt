package kafka.transactionsAmount.stream.processor

import java.math.BigInteger

class TransactionsAmountCalculator {
    companion object {
        fun sum(amount: String, previousAmount: String): String {
            val result = BigInteger(amount).add(BigInteger(previousAmount))
            // uncomment when starting from block 0
//          if(result < BigInteger.ZERO){
//            result = BigInteger.ZERO
//          }
            return result.toString()
        }

        fun multiply(gas: String, gasPrice: String): String{
            return (BigInteger(gas) * BigInteger(gasPrice)).toString()
        }
    }
}
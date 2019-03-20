package kafka.transactionsNumber.stream.processor
import java.math.BigInteger

class TransactionsNumberCalculator {
    companion object {
        fun sum(transactionsNumber: String, previousTransactionsNumber: String): String {
            var result = BigInteger(transactionsNumber).add(BigInteger(previousTransactionsNumber))
            return result.toString()
        }
    }
}
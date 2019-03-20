package kafka.transactionsNumber.stream.processor
import java.math.BigInteger

class TransactionsNumberCalculator {
    companion object {
        fun increaseByOne(transactionsNumber: String): String{
            return (transactionsNumber.toInt() + 1).toString()
        }

        fun subtract(previousTransactionsNumber: String, transactionsNumber: String): String{
            return (previousTransactionsNumber.toInt() - transactionsNumber.toInt()).toString()
        }
    }
}
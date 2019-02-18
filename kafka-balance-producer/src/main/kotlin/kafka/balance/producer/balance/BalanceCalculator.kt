package kafka.balance.producer.balance

import kafka.balance.producer.messages.Messages
import java.math.BigInteger
import java.math.BigInteger.ZERO

class BalanceCalculator {

    fun calculateAccountBalances(block: Messages.Block): HashMap<String, BigInteger> {
        val accountTransactions = ArrayList<AccountTransaction>()
        block.transactionsList.forEach { transaction ->
            val traces = transaction.tracesList
            traces.forEach { transactionTrace ->
                val action = transactionTrace.action
                val call = transactionTrace.call
                val reward = transactionTrace.reward
                val create = transactionTrace.create
                val suicide = transactionTrace.suicide
                when (action) {
                    Messages.Trace.Action.CALL -> {
                        accountTransactions.add(AccountTransaction(transaction.from, zeroIfMissing(transaction.gas).negate()))
                        accountTransactions.add(AccountTransaction(transaction.to, zeroIfMissing(transaction.gas)))
                    }
                    Messages.Trace.Action.REWARD -> {
                        accountTransactions.add(AccountTransaction(transaction.from, zeroIfMissing(transaction.gas)))
                    }
                    Messages.Trace.Action.CREATE -> {
                        accountTransactions.add(AccountTransaction(transaction.from, zeroIfMissing(transaction.gas).negate()))
                    }
                    Messages.Trace.Action.SUICIDE -> {
                        accountTransactions.add(AccountTransaction(transaction.to, zeroIfMissing(suicide.balance)))
                    }
                    else -> {
                    }
                }
            }
        }
        return toAccountBalances(accountTransactions)
    }

    private fun zeroIfMissing(amount: String): BigInteger {
        return if (amount.isEmpty()) ZERO else BigInteger(amount)
    }

    private fun toAccountBalances(accountTransactions: List<AccountTransaction>): HashMap<String, BigInteger> {
        val accountBalances = HashMap<String, BigInteger>()
        for (transaction in accountTransactions) {
            if(transaction.account.isEmpty()) {
                continue
            }
            if (accountBalances.containsKey(transaction.account)) {
                val previousBalance = accountBalances.get(transaction.account)
                val currentBalance = previousBalance!!.add(transaction.balance)
                accountBalances.put(transaction.account, zeroIfNegative(currentBalance))
            } else {
                accountBalances.put(transaction.account, zeroIfNegative(transaction.balance))
            }
        }
        return accountBalances
    }

    private fun zeroIfNegative(balance: BigInteger): BigInteger {
        return if (balance.compareTo(ZERO) < 0) ZERO else balance
    }
}
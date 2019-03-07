package kafka.balance.stream.processor

import kafka.balance.stream.messages.Messages
import java.math.BigInteger


class AddressBalanceExtractor {

    private var addressBalanceMap: HashMap<String, String>? = null
    fun extract(block: Messages.Block): HashMap<String, String>? {
        addressBalanceMap = HashMap()
        addAddressBalanceForGas(block)
        addAddressBalanceFromTraces(block)
        return addressBalanceMap
    }

    private fun addAddressBalanceForGas(block: Messages.Block) {

        var rewardForBlockAuthor = BigInteger.ZERO
        block.transactionsList.forEach { transaction ->
            val gasByPrice = BigInteger(transaction.gas).multiply(BigInteger(transaction.gasPrice))
            addToAddressBalance(transaction.from, "-" + gasByPrice.toString())
            rewardForBlockAuthor = rewardForBlockAuthor.add(gasByPrice)
        }
        addToAddressBalance(block.author, rewardForBlockAuthor.toString())
    }

    private fun addAddressBalanceFromTraces(block: Messages.Block) {
        val traces = block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
        traces.forEach { trace ->
            when (trace.type) {
                "reward" -> addToAddressBalance(trace.reward.author, trace.reward.value)
                "call" -> {
                    addToAddressBalance(trace.call.from, "-" + trace.call.value)
                    addToAddressBalance(trace.call.to, trace.call.value)
                }
                "suicide" -> addToAddressBalance(trace.suicide.refundAddress, trace.suicide.balance)
                "create" -> addToAddressBalance(trace.create.from, trace.create.value)
            }
        }
    }

    private fun addToAddressBalance(address: String, amount: String) {
        val previousBalance = addressBalanceMap!!.get(address)
        if (previousBalance == null) {
            addressBalanceMap!!.put(address, amount)
        } else {
            addressBalanceMap!!.put(address, BalanceCalculator.sum(amount, previousBalance))
        }
    }


}
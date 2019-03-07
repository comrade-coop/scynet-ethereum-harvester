package kafka.balance.stream.processor

import kafka.balance.stream.messages.Messages
import java.math.BigInteger


class AddressBalanceExtractor {

    private var addressBalance: HashMap<String, String>? = null
    fun extract(block: Messages.Block): HashMap<String, String>?{
        addressBalance = HashMap()
        accountForGas(block)
        addressBalanceFromTraces(block)
        return  addressBalance
    }

    private fun accountForGas(block: Messages.Block) {

        var rewardForBlockAuthor = BigInteger.ZERO
        block.transactionsList.map { transaction ->
            addToAddressBalance(transaction.from, "-" + multiplyGasByPrice(transaction.gas, transaction.gasPrice).toString())
            rewardForBlockAuthor += multiplyGasByPrice(transaction.gas, transaction.gasPrice)
        }
        addToAddressBalance(block.author, rewardForBlockAuthor.toString())
    }
    private fun multiplyGasByPrice(gas: String, gasPrice: String): BigInteger{
        return BigInteger(gas) * BigInteger(gasPrice)
    }

    private fun addressBalanceFromTraces(block: Messages.Block){
        val traces = block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
        traces.forEach { trace ->
            when (trace.type) {
                "reward" -> addToAddressBalance(trace.reward.author, trace.reward.value)
                "call" -> {
                    addToAddressBalance(trace.call.from, "-" + trace.call.value)
                    addToAddressBalance(trace.call.to, trace.call.value)
                }
                "suicide" ->   addToAddressBalance(trace.suicide.refundAddress, trace.suicide.balance)
                "create" -> addToAddressBalance(trace.create.from, trace.create.value)
            }
        }
    }

    private fun addToAddressBalance(address: String, amount: String){
        val previousBalance = addressBalance!!.get(address)
        if(previousBalance.isNullOrEmpty()){
            addressBalance!!.put(address, amount)
        } else {
            addressBalance!!.put(address, BalanceSummator.sum(amount, previousBalance))
        }
    }



}
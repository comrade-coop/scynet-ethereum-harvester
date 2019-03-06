package kafka.balance.stream

import kafka.balance.stream.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger

class AddressBalanceProcessor: Processor<String, Messages.Block> {

    private var context: ProcessorContext? = null
    private var kvStore: KeyValueStore<String, String>? = null
    private var addressBalance: HashMap<String, String>? = null

    override fun process(blockNumber: String?, block: Messages.Block) {
        println(blockNumber)
        addressBalance = HashMap()
        accountForGas(block)
        addressBalanceFromTraces(block)
        synchronizeAddressBalanceAndStore()

        val addressBalanceBuilder = AddressBalance.AddressBalanceMap.newBuilder()
        addressBalance!!.forEach { entry->
            addressBalanceBuilder.putAddressBalance(entry.key, entry.value)
        }

        context!!.forward(blockNumber, addressBalanceBuilder.build())
        context!!.commit()
    }

    override fun init(context: ProcessorContext) {
        // keep the processor context locally because we need it in punctuate() and commit()
        this.context = context

        this.kvStore = context.getStateStore("AddressBalance") as KeyValueStore<String, String>
    }

    override fun close() {
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
        if(previousBalance == null){
            addressBalance!!.put(address, amount)
        } else {
            addressBalance!!.put(address, sum(amount, previousBalance))
        }
    }

    private fun sum(balance: String, previousBalance: String): String {
        var result = BigInteger(balance) + BigInteger(previousBalance)
        // uncomment when starting from block 0
//        if(result < BigInteger.ZERO){
//            result = BigInteger.ZERO
//        }
        return result.toString()
    }

    private fun synchronizeAddressBalanceAndStore(){
        addressBalance!!.forEach { address, balance ->
            val previousBalance = kvStore!!.get(address)
            if (previousBalance == null){
                kvStore!!.put(address, balance)
            } else {
                kvStore!!.put(address, sum(balance, previousBalance))
                addressBalance!!.put(address, sum(balance, previousBalance))
            }
        }
    }
}
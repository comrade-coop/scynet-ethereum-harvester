package kafka.balance.stream.processor

import kafka.balance.stream.messages.AddressFeature
import kafka.balance.stream.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore

class AddressBalanceProcessor: Processor<String, Messages.Block> {

    private var context: ProcessorContext? = null
    private var AddressBalanceStore: KeyValueStore<String, String>? = null

    override fun process(blockNumber: String, block: Messages.Block) {
        extract(block)

        val addressFeatureBuilder = AddressFeature.AddressFeatureMap.newBuilder()
        AddressBalanceStore!!.all().forEach { entry->
            addressFeatureBuilder.putAddressFeature(entry.key, entry.value)
        }

        context!!.forward(blockNumber, addressFeatureBuilder.build())
        context!!.commit()
    }

    override fun init(context: ProcessorContext) {
        this.context = context

        this.AddressBalanceStore = context.getStateStore("AddressBalance") as KeyValueStore<String, String>
    }

    override fun close() {
    }


    private fun extract(block: Messages.Block){
        accountForGas(block)
        addressBalanceFromTraces(block)
    }

    private fun accountForGas(block: Messages.Block) {

        var rewardForBlockAuthor = "0"
        block.transactionsList.forEach { transaction ->
            addToAddressBalanceStore(transaction.from, "-" + BalanceCalculator.multiply(transaction.receipt.gasUsed, transaction.gasPrice))
            rewardForBlockAuthor = BalanceCalculator.sum(rewardForBlockAuthor, BalanceCalculator.multiply(transaction.receipt.gasUsed, transaction.gasPrice))
        }
        addToAddressBalanceStore(block.author, rewardForBlockAuthor)
    }

    private fun addressBalanceFromTraces(block: Messages.Block){
        val traces = block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
        traces.forEach { trace ->
            when (trace.type) {
                "reward" -> addToAddressBalanceStore(trace.reward.author, trace.reward.value)
                "call" -> {
                    addToAddressBalanceStore(trace.call.from, "-" + trace.call.value)
                    addToAddressBalanceStore(trace.call.to, trace.call.value)
                }
                "suicide" ->   addToAddressBalanceStore(trace.suicide.refundAddress, trace.suicide.balance)
                "create" -> addToAddressBalanceStore(trace.create.from, trace.create.value)
            }
        }
    }

    private fun addToAddressBalanceStore(address: String, amount: String){
        val previousBalance = AddressBalanceStore!!.get(address)
        if(previousBalance.isNullOrEmpty()){
            AddressBalanceStore!!.put(address, amount)
        } else {
            AddressBalanceStore!!.put(address, BalanceCalculator.sum(amount, previousBalance))
        }
    }
}
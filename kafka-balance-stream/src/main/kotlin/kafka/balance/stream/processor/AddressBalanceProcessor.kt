package kafka.balance.stream.processor

import harvester.common.messages.AddressFeature
import harvester.common.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore

class AddressBalanceProcessor: Processor<String, Messages.Block> {

    private var context: ProcessorContext? = null
    private var addressBalanceStore: KeyValueStore<String, String>? = null
    private val currentAddresses: MutableSet<String> = HashSet()
    private var lastProcessedBlock: Int? = null


    override fun process(blockNumber: String, block: Messages.Block) {

        if(lastProcessedBlock != null && lastProcessedBlock != blockNumber.toInt() - 1){
            println()
        }

        currentAddresses.clear()
        extract(block)

        val addressFeatureBuilder = AddressFeature.AddressFeatureMap.newBuilder()
        currentAddresses.forEach { address->
            val balance = addressBalanceStore!!.get(address)
            addressFeatureBuilder.putAddressFeature(address, balance)
        }

        context!!.forward(blockNumber, addressFeatureBuilder.build())
        context!!.commit()

        println(blockNumber)
    }

    override fun init(context: ProcessorContext) {
        this.context = context

        this.addressBalanceStore = context.getStateStore("AddressBalance") as KeyValueStore<String, String>
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
                "reward" ->{
                    addToAddressBalanceStore(trace.reward.author, trace.reward.value)
                    currentAddresses.add(trace.reward.author)
                }
                "call" -> {
                    addToAddressBalanceStore(trace.call.from, "-" + trace.call.value)
                    addToAddressBalanceStore(trace.call.to, trace.call.value)
                    currentAddresses.add(trace.call.from)
                    currentAddresses.add(trace.call.to)
                }
                "suicide" -> {
                    addToAddressBalanceStore(trace.suicide.refundAddress, trace.suicide.balance)
                    addToAddressBalanceStore(trace.suicide.address, "-" + trace.suicide.balance)
                    currentAddresses.add(trace.suicide.refundAddress)
                    currentAddresses.add(trace.suicide.address)

                }
                "create" -> {
                    addToAddressBalanceStore(trace.create.from,"-" + trace.create.value)
                    addToAddressBalanceStore(trace.result.address, trace.create.value)
                    currentAddresses.add(trace.create.from)
                    currentAddresses.add(trace.result.address)
                }
            }
        }
    }

    private fun addToAddressBalanceStore(address: String, amount: String){
        val previousBalance = addressBalanceStore!!.get(address)
        if(previousBalance.isNullOrEmpty()){
            addressBalanceStore!!.put(address, amount)
        } else {
            addressBalanceStore!!.put(address, BalanceCalculator.sum(amount, previousBalance))
        }
    }
}
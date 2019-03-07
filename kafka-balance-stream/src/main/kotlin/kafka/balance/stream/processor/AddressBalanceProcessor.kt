package kafka.balance.stream.processor

import kafka.balance.stream.messages.AddressBalance
import kafka.balance.stream.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore

class AddressBalanceProcessor(val addressBalanceExtractor: AddressBalanceExtractor): Processor<String, Messages.Block> {

    private var context: ProcessorContext? = null
    private var kvStore: KeyValueStore<String, String>? = null
    private var addressBalance: HashMap<String, String>? = null

    override fun process(blockNumber: String, block: Messages.Block) {
        addressBalance = addressBalanceExtractor.extract(block)
        synchronizeAddressBalanceAndStore()

        val addressBalanceBuilder = AddressBalance.AddressBalanceMap.newBuilder()
        addressBalance!!.forEach { entry->
            addressBalanceBuilder.putAddressBalance(entry.key, entry.value)
        }

        context!!.forward(blockNumber, addressBalanceBuilder.build())
        context!!.commit()
    }

    override fun init(context: ProcessorContext) {
        this.context = context

        this.kvStore = context.getStateStore("AddressBalance") as KeyValueStore<String, String>
    }

    override fun close() {
    }

    private fun synchronizeAddressBalanceAndStore(){
        addressBalance!!.forEach { address, balance ->
            val previousBalance = kvStore!!.get(address)
            if (previousBalance == null){
                kvStore!!.put(address, balance)
            } else {
                kvStore!!.put(address, BalanceCalculator.sum(balance, previousBalance))
                addressBalance!!.put(address, BalanceCalculator.sum(balance, previousBalance))
            }
        }
    }
}
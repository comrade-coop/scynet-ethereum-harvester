package kafka.balance.stream.processor

import kafka.balance.stream.messages.*
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

        val addressFeatureBuilder = AddressFeature.AddressFeatureMap.newBuilder()
        addressBalance!!.forEach { entry->
            addressFeatureBuilder.putAddressFeature(entry.key, entry.value)
        }

        context!!.forward(blockNumber, addressFeatureBuilder.build())
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
                kvStore!!.put(address, BalanceSummator.sum(balance, previousBalance))
                addressBalance!!.put(address, BalanceSummator.sum(balance, previousBalance))
            }
        }
    }
}
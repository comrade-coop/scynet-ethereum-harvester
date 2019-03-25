package harvester.common.processor

import harvester.common.messages.*
import org.apache.kafka.streams.state.KeyValueStore

abstract class AddressFeatureTickProcessor: TickFeatureProcessor() {
    protected var addressFeatureStore: KeyValueStore<String, String>? = null
    protected var blockNumberAddressFeatureStore: KeyValueStore<Int, AddressFeature.AddressFeatureMap>? = null

    override fun extract(block: Messages.Block) {
        addAddressFeatureBuilderBlock(block)
        extractBlock(block)
    }

    override fun removeBlockEntriesFromFeaturesStores(firstBlockNumber: Int) {
        val firstBlockAddressFeature = blockNumberAddressFeatureStore!!.get(firstBlockNumber)
        removeBlockEntriesFromFeatureStore(firstBlockAddressFeature)
        blockNumberAddressFeatureStore!!.delete(firstBlockNumber)

    }

    override fun initStores(){
        addressFeatureStore = context!!.getStateStore("AddressFeatureStore") as KeyValueStore<String, String>
        blockNumberAddressFeatureStore = context!!.getStateStore("BlockNumberAddressFeatureStore") as KeyValueStore<Int, AddressFeature.AddressFeatureMap>
    }

    private fun removeBlockEntriesFromFeatureStore(firstBlockAddressFeature: AddressFeature.AddressFeatureMap){
        firstBlockAddressFeature.addressFeatureMap.forEach { address, feature ->
            val previousFeature = addressFeatureStore!!.get(address)
            addressFeatureStore!!.put(address, subtract( previousFeature, feature ))
        }
    }

    private fun subtract(previousFeature: String?, feature: String?): String? {
        return (previousFeature!!.toBigDecimal() - feature!!.toBigDecimal()).toString()

    }

    private fun addAddressFeatureBuilderBlock(block: Messages.Block){
        currentBlockNumber = block.number.toInt()
        val builder = AddressFeature.AddressFeatureMap.newBuilder()
        blockNumberAddressFeatureStore!!.put(currentBlockNumber, builder.build())
    }


    override fun buildFeatureMap(): AddressFeature.AddressFeatureMap{
        val builder = AddressFeature.AddressFeatureMap.newBuilder()
        addressFeatureStore!!.all().forEach { addressTransactionsNumber ->
            builder.putAddressFeature(addressTransactionsNumber.key, addressTransactionsNumber.value)
        }
        return builder.build()
    }

    protected abstract fun extractBlock(block: Messages.Block)
}

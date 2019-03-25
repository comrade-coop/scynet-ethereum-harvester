package harvester.common.processor

import harvester.common.messages.*
import org.apache.kafka.streams.state.KeyValueStore

abstract class BlockFeatureTickProcessor(private val FEATURE: String): TickFeatureProcessor() {

    protected var featureStore: KeyValueStore<String, String>? = null
    protected var blockNumberFeatureStore: KeyValueStore<Int, AddressFeature.AddressFeatureMap>? = null

    override fun initStores() {
        featureStore = context!!.getStateStore("FeatureStore") as KeyValueStore<String, String>
        blockNumberFeatureStore = context!!.getStateStore("BlockNumberFeatureStore") as KeyValueStore<Int, AddressFeature.AddressFeatureMap>
    }

    override fun buildFeatureMap(): AddressFeature.AddressFeatureMap {
        val builder = AddressFeature.AddressFeatureMap.newBuilder()
        val featureValue = featureStore!!.get(FEATURE)
        return builder.putAddressFeature(FEATURE,featureValue).build()
    }


    override fun extract(block: Messages.Block) {
        addAddressFeatureBuilderBlock(block)
        extractBlock(block)
    }

    private fun addAddressFeatureBuilderBlock(block: Messages.Block){
        currentBlockNumber = block.number.toInt()
        val builder = AddressFeature.AddressFeatureMap.newBuilder()
        blockNumberFeatureStore!!.put(currentBlockNumber, builder.build())
    }

    override fun removeBlockEntriesFromFeaturesStores(firstBlockNumber: Int) {
        val featureValue = blockNumberFeatureStore!!.get(firstBlockNumber).getAddressFeatureOrThrow(FEATURE)
        removeBlockEntryFromFeatureStore(featureValue)
        blockNumberFeatureStore!!.delete(firstBlockNumber)
    }

    private fun removeBlockEntryFromFeatureStore(featureValue: String?) {
        val oldValue = featureStore!!.get(FEATURE)
        featureStore!!.put(FEATURE, subtract(oldValue, featureValue!!))
    }

    private fun subtract(oldValue:String, value: String): String{
        return (oldValue.toBigDecimal() - value.toBigDecimal()).toString()
    }

    protected abstract fun extractBlock(block: Messages.Block)
}

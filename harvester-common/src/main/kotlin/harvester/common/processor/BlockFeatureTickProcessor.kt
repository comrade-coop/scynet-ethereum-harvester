package harvester.common.processor

import harvester.common.messages.AddressFeature
import harvester.common.messages.Messages
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger

abstract class BlockFeatureTickProcessor(protected val PROPERTY: String) : TickFeatureProcessor() {

    protected var featureStore: KeyValueStore<String, String>? = null
    protected var blockNumberFeatureStore: KeyValueStore<Int, AddressFeature.AddressFeatureMap>? = null

    private val ZERO = "0"

    override fun initStores() {
        featureStore = context!!.getStateStore("Feature") as KeyValueStore<String, String>
        blockNumberFeatureStore = context!!.getStateStore("BlockNumberFeature") as KeyValueStore<Int, AddressFeature.AddressFeatureMap>
    }

    override fun addFeatureBuilderWithTimestampForBlock(block: Messages.Block) {
        featureStore!!.putIfAbsent(PROPERTY, ZERO)
        currentBlockNumber = block.number.toInt()
        val builder = AddressFeature.AddressFeatureMap.newBuilder().putAddressFeature("timestamp", block.timestamp)
        blockNumberFeatureStore!!.put(currentBlockNumber, builder.build())
    }

    override fun slideTickForward(timestamp: BigInteger) {
        while (notInTick(timestamp)) {
            removeBlockEntryFromFeatureStores(firstBlockNumber!!)

            setFirstBlockNumber(firstBlockNumber!! + ONE)

            val firstBlockTimestamp = blockNumberFeatureStore!!
                    .get(firstBlockNumber)
                    .getAddressFeatureOrDefault("timestamp", NEGATIVE_ONE.toString())
                    .toBigInteger()
            setEndOfTick(firstBlockTimestamp)
        }
    }

    override fun buildFeatureMap(): AddressFeature.AddressFeatureMap {
        val builder = AddressFeature.AddressFeatureMap.newBuilder()
        val featureValue = featureStore!!.get(PROPERTY)
        return builder.putAddressFeature(PROPERTY, featureValue).build()
    }

    protected fun addToBlockNumberFeatureStore(value: String) {
        val builder = blockNumberFeatureStore!!.get(currentBlockNumber).toBuilder()
        builder.putAddressFeature(PROPERTY, value)
        blockNumberFeatureStore!!.put(currentBlockNumber, builder.build())
    }

    protected fun addToFeatureStore(value: String) {
        val oldValue = featureStore!!.get(PROPERTY)
        println(oldValue)
        featureStore!!.put(PROPERTY, FeatureCalculator.sum(oldValue, value))
    }

    private fun removeBlockEntryFromFeatureStores(firstBlockNumber: Int) {
        val blockFeatureValue = blockNumberFeatureStore!!.get(firstBlockNumber).getAddressFeatureOrThrow(PROPERTY)
        blockNumberFeatureStore!!.delete(firstBlockNumber)
        recalculateFeatureValue(blockFeatureValue)
    }

    private fun recalculateFeatureValue(deletedFeatureValue: String){
        val oldValue = featureStore!!.get(PROPERTY)
        featureStore!!.put(PROPERTY, FeatureCalculator.subtract(oldValue, deletedFeatureValue))
    }

}
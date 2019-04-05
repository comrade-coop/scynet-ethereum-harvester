package harvester.common.processor

import harvester.common.messages.AddressFeature
import harvester.common.messages.Messages
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger

abstract class BlockFeatureTickProcessor(protected val FEATURE: String,
                                         protected val FEATURE_CALCULATION_STRATEGY: FeatureCalculationStrategy,
                                         TICK_TIME_SECONDS: String?) : TickFeatureProcessor(TICK_TIME_SECONDS) {

    protected var featureStore: KeyValueStore<String, String>? = null
    protected var blockNumberFeatureStore: KeyValueStore<Int, AddressFeature.AddressFeatureMap>? = null

    private val ZERO = "0"

    override fun initStores() {
        featureStore = context!!.getStateStore("Feature") as KeyValueStore<String, String>
        blockNumberFeatureStore = context!!.getStateStore("BlockNumberFeature") as KeyValueStore<Int, AddressFeature.AddressFeatureMap>
    }

    override fun addFeatureBuilderWithTimestampForBlock(block: Messages.Block) {
        featureStore!!.putIfAbsent(FEATURE, ZERO)
        currentBlockNumber = block.number.toInt()
        val builder = AddressFeature.AddressFeatureMap.newBuilder().putAddressFeature("timestamp", block.timestamp)
        blockNumberFeatureStore!!.put(currentBlockNumber, builder.build())
    }

    override fun slideTickForward(timestamp: BigInteger) {
        while (notInTick(timestamp)) {
            val blockFeatureValue = blockNumberFeatureStore!!.get(firstBlockNumber).getAddressFeatureOrThrow(FEATURE)
            removeBlockEntryFromStore(firstBlockNumber!!)
            updateFeatureStore(blockFeatureValue, true)

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
        val featureValue = featureStore!!.get(FEATURE)
        return builder.putAddressFeature(FEATURE, featureValue).build()
    }

    protected fun updateStores(value: String) {
        val builder = blockNumberFeatureStore!!.get(currentBlockNumber).toBuilder()
        builder.putAddressFeature(FEATURE, value)
        blockNumberFeatureStore!!.put(currentBlockNumber, builder.build())
        updateFeatureStore(value, false)
    }

    private fun updateFeatureStore(value: String, isValueRemoved: Boolean) {
        var updatedFeatureValue = ZERO
        if (FeatureCalculationStrategy.AMOUNT.equals(FEATURE_CALCULATION_STRATEGY)) {
            updatedFeatureValue = amount(value, isValueRemoved)
        } else if (FeatureCalculationStrategy.AVERAGE.equals(FEATURE_CALCULATION_STRATEGY)) {
            updatedFeatureValue = average()
        }
        println("Feature value: " + updatedFeatureValue)
        featureStore!!.put(FEATURE, updatedFeatureValue)
    }

    private fun amount(value: String, isValueRemoved: Boolean): String {
        if (isValueRemoved) {
            return amountWithRemovedValue(value)
        }
        return amountWithAddedValue(value)
    }

    private fun amountWithRemovedValue(removedValue: String): String {
        val oldValue = featureStore!!.get(FEATURE)
        return FeatureCalculator.subtract(oldValue, removedValue)
    }

    private fun amountWithAddedValue(addedValue: String): String {
        val oldValue = featureStore!!.get(FEATURE)
        return FeatureCalculator.sum(oldValue, addedValue)
    }

    private fun average(): String {
        var updatedFeatureValue = BigInteger.ZERO
        blockNumberFeatureStore!!.all().forEach { keyValue ->
            updatedFeatureValue += keyValue.value.getAddressFeatureOrDefault(FEATURE, ZERO).toBigInteger()
        }
        return updatedFeatureValue.toString()
    }

    private fun removeBlockEntryFromStore(firstBlockNumber: Int) {
        blockNumberFeatureStore!!.delete(firstBlockNumber)
    }

}
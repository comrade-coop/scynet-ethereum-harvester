package harvester.common.processor

import harvester.common.messages.AddressFeature
import harvester.common.messages.Messages
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger

abstract class AddressFeatureTickProcessor() : TickFeatureProcessor() {

    protected var addressFeatureStore: KeyValueStore<String, String>? = null
    protected var blockNumberAddressFeatureStore: KeyValueStore<Int, AddressFeature.AddressFeatureMap>? = null

    override fun initStores() {
        this.addressFeatureStore = context!!.getStateStore("AddressFeature") as KeyValueStore<String, String>
        this.blockNumberAddressFeatureStore = context!!.getStateStore("BlockNumberAddressFeature") as KeyValueStore<Int, AddressFeature.AddressFeatureMap>
    }

    override fun addFeatureBuilderWithTimestampForBlock(block: Messages.Block) {
        currentBlockNumber = block.number.toInt()
        val builder = AddressFeature.AddressFeatureMap.newBuilder().putAddressFeature("timestamp", block.timestamp)
        blockNumberAddressFeatureStore!!.put(currentBlockNumber, builder.build())
    }

    override fun slideTickForward(timestamp: BigInteger) {
        while (notInTick(timestamp)) {
            val firstBlockAddressFeature = blockNumberAddressFeatureStore!!.get(firstBlockNumber)
            removeBlockEntriesFromFeatureStore(firstBlockAddressFeature)
            blockNumberAddressFeatureStore!!.delete(firstBlockNumber)

            setFirstBlockNumber(firstBlockNumber!! + ONE)

            val firstBlockTimestamp = blockNumberAddressFeatureStore!!
                    .get(firstBlockNumber)
                    .getAddressFeatureOrDefault("timestamp", NEGATIVE_ONE.toString())
                    .toBigInteger()
            setEndOfTick(firstBlockTimestamp)
        }
    }

    override fun buildFeatureMap(): AddressFeature.AddressFeatureMap {
        val builder = AddressFeature.AddressFeatureMap.newBuilder()
        addressFeatureStore!!.all().forEach { addressFeature ->
            builder.putAddressFeature(addressFeature.key, addressFeature.value)
        }
        return builder.build()
    }

    private fun removeBlockEntriesFromFeatureStore(firstBlockAddressFeature: AddressFeature.AddressFeatureMap) {
        firstBlockAddressFeature.addressFeatureMap.forEach { address, feature ->
            if (address == "timestamp") return@forEach
            val previousFeature = addressFeatureStore!!.get(address)
            addressFeatureStore!!.put(address, FeatureCalculator.subtract(previousFeature, feature))
        }
    }
}

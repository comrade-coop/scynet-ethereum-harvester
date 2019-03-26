package harvester.common.processor

import harvester.common.messages.AddressFeature
import harvester.common.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger

abstract class BlockFeatureTickProcessor() : Processor<String, Messages.Block> {

    val ONE: Int = 1
    val NEGATIVE_ONE: Int = -1

    protected var addressFeatureStore: KeyValueStore<String, String>? = null
    protected var blockNumberAddressFeatureStore: KeyValueStore<Int, AddressFeature.AddressFeatureMap>? = null
    protected var currentBlockNumber: Int? = null

    private var context: ProcessorContext? = null
    private var synchronizationStore: KeyValueStore<String, String>? = null
    private var endOfTick: BigInteger? = null
    private var firstBlockNumber: Int? = null
    private var lastProcessedBlockNumber: Int? = null

    override fun process(blockNumber: String, block: Messages.Block) {
        try {
            process(block)
            println(blockNumber)
        } catch (e: Exception) {
            // TODO use logger for this
            println("Exception occurred: $e while processing block: $blockNumber")
        }
    }

    override fun init(context: ProcessorContext) {
        this.context = context

        this.addressFeatureStore = context.getStateStore("AddressFeature") as KeyValueStore<String, String>
        this.blockNumberAddressFeatureStore = context.getStateStore("BlockNumberAddressFeature") as KeyValueStore<Int, AddressFeature.AddressFeatureMap>
        this.synchronizationStore = context.getStateStore("SynchronizationStore") as KeyValueStore<String, String>

        val firstBlockNumberString = synchronizationStore!!.get("firstBlockNumber")
        firstBlockNumber = if (firstBlockNumberString.isNullOrEmpty()) NEGATIVE_ONE else firstBlockNumberString.toInt()

        val endOfTickString = synchronizationStore!!.get("endOfTick")
        endOfTick = if (endOfTickString.isNullOrEmpty()) BigInteger.valueOf(NEGATIVE_ONE.toLong()) else endOfTickString.toBigInteger()

        val lastProcessedBlockNumberString = synchronizationStore!!.get("lastProcessedBlockNumber")
        lastProcessedBlockNumber = if (lastProcessedBlockNumberString.isNullOrEmpty()) NEGATIVE_ONE else lastProcessedBlockNumberString.toInt()
    }

    override fun close() {
    }

    private fun process(block: Messages.Block) {
        val blockNumber = block.number.toInt()
        if (processed(blockNumber)) {
            return
        }
        if (notSetEndOfTick()) {
            setEndOfTick(block.timestamp.toBigInteger())
            setFirstBlockNumber(blockNumber)
        }
        addAddressFeatureBuilderWithTimestampForBlock(block)

        if (notInTick(block.timestamp.toBigInteger())) {
            commitFeature()
            slideTickForward(block.timestamp.toBigInteger())
        }
        extract(block)
        setLastProcessedBlock(blockNumber.toString())
    }

    private fun processed(blockNumber: Int): Boolean {
        if (blockNumber <= lastProcessedBlockNumber!!) {
            return true
        }
        return false
    }

    private fun notSetEndOfTick(): Boolean {
        if (endOfTick == BigInteger.valueOf(NEGATIVE_ONE.toLong()))
            return true
        return false
    }

    private fun setEndOfTick(timestamp: BigInteger) {
        endOfTick = timestamp + BigInteger.valueOf(3600)
        synchronizationStore!!.put("endOfTick", endOfTick.toString())
    }

    private fun setFirstBlockNumber(blockNumber: Int) {
        firstBlockNumber = blockNumber
        synchronizationStore!!.put("firstBlockNumber", firstBlockNumber.toString())
    }

    private fun addAddressFeatureBuilderWithTimestampForBlock(block: Messages.Block) {
        currentBlockNumber = block.number.toInt()
        val builder = AddressFeature.AddressFeatureMap.newBuilder().putAddressFeature("timestamp", block.timestamp)
        blockNumberAddressFeatureStore!!.put(currentBlockNumber, builder.build())
    }

    private fun notInTick(timestamp: BigInteger): Boolean {
        if (timestamp > endOfTick)
            return true
        return false
    }

    private fun commitFeature() {
        val addressFeatureMap = buildAddressFeatureMap()
        context!!.forward(endOfTick.toString(), addressFeatureMap)
        context!!.commit()
    }

    private fun slideTickForward(timestamp: BigInteger) {
        while (notInTick(timestamp)) {
            val firstBlockAddressFeature = blockNumberAddressFeatureStore!!.get(firstBlockNumber)
            removeBlockEntriesFromAddressFeatureStore(firstBlockAddressFeature)
            blockNumberAddressFeatureStore!!.delete(firstBlockNumber)

            setFirstBlockNumber(firstBlockNumber!! + ONE)

            val firstBlockTimestamp = blockNumberAddressFeatureStore!!
                    .get(firstBlockNumber)
                    .getAddressFeatureOrDefault("timestamp", NEGATIVE_ONE.toString())
                    .toBigInteger()
            setEndOfTick(firstBlockTimestamp)
        }
    }

    private fun setLastProcessedBlock(blockNumber: String) {
        synchronizationStore!!.put("lastProcessedBlockNumber", blockNumber)
    }

    private fun buildAddressFeatureMap(): AddressFeature.AddressFeatureMap {
        val builder = AddressFeature.AddressFeatureMap.newBuilder()
        addressFeatureStore!!.all().forEach { addressFeature ->
            builder.putAddressFeature(addressFeature.key, addressFeature.value)
        }
        return builder.build()
    }

    abstract fun extract(block: Messages.Block)

    private fun removeBlockEntriesFromAddressFeatureStore(firstBlockAddressFeature: AddressFeature.AddressFeatureMap) {
        firstBlockAddressFeature.addressFeatureMap.forEach { address, feature ->
            if (address == "timestamp") return@forEach
            val previousFeature = addressFeatureStore!!.get(address)
            addressFeatureStore!!.put(address, FeatureCalculator.subtract(previousFeature, feature))
        }
    }
}

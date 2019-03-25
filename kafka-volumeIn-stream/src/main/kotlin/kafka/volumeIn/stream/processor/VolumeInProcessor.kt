package kafka.volumeIn.stream.processor

import harvester.common.messages.AddressFeature
import harvester.common.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger

class VolumeInProcessor() : Processor<String, Messages.Block> {

    private var context: ProcessorContext? = null
    private var addressVolumeInStore: KeyValueStore<String, String>? = null
    private var blockNumberAddressVolumeInStore: KeyValueStore<Int, AddressFeature.AddressFeatureMap>? = null
    private var synchronizationStore: KeyValueStore<String, String>? = null
    private var endOfTick: BigInteger? = null
    private var firstBlockNumber: Int? = null
    private var lastProcessedBlockNumber: Int? = null
    private var currentBlockNumber: Int? = null

    override fun process(blockNumber: String, block: Messages.Block) {
        try {
            process(block)
        } catch (e: Exception) {
            // TODO use logger for this
            println("Exception occurred: $e while processing block: $blockNumber")
        }
    }

    private fun process(block: Messages.Block) {
        val blockNumber = block.number
        if (processed(blockNumber.toInt())) {
            return
        }
        if (notSetEndOfTick()) {
            setEndOfTick(block.timestamp.toBigInteger())
            setFirstBlockNumber(blockNumber.toInt())
        }
        addAddressFeatureBuilderWithTimestampForBlock(block)

        if (notInTick(block.timestamp.toBigInteger())) {
            commitVolumeIn()
            slideTickForward(block.timestamp.toBigInteger())
        }

        extract(block)
        setLastProcessedBlock(blockNumber)
    }

    override fun init(context: ProcessorContext) {
        this.context = context

        this.addressVolumeInStore = context.getStateStore("AddressVolumeIn") as KeyValueStore<String, String>
        this.blockNumberAddressVolumeInStore = context.getStateStore("BlockNumberAddressVolumeIn") as KeyValueStore<Int, AddressFeature.AddressFeatureMap>
        this.synchronizationStore = context.getStateStore("SynchronizationStore") as KeyValueStore<String, String>

        val firstBlockNumberString = synchronizationStore!!.get("firstBlockNumber")
        firstBlockNumber = if (firstBlockNumberString.isNullOrEmpty()) -1 else firstBlockNumberString.toInt()

        val endOfTickString = synchronizationStore!!.get("endOfTick")
        endOfTick = if (endOfTickString.isNullOrEmpty()) BigInteger.valueOf(-1) else endOfTickString.toBigInteger()

        val lastProcessedBlockNumberString = synchronizationStore!!.get("lastProcessedBlockNumber")
        lastProcessedBlockNumber = if (lastProcessedBlockNumberString.isNullOrEmpty()) -1 else lastProcessedBlockNumberString.toInt()
    }

    override fun close() {
    }

    private fun processed(blockNumber: Int): Boolean {
        if (blockNumber <= lastProcessedBlockNumber!!) {
            return true
        }
        return false
    }

    private fun notSetEndOfTick(): Boolean {
        if (endOfTick == BigInteger.valueOf(-1))
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
        blockNumberAddressVolumeInStore!!.put(currentBlockNumber, builder.build())
    }

    private fun notInTick(timestamp: BigInteger): Boolean {
        if (timestamp > endOfTick)
            return true
        return false
    }

    private fun commitVolumeIn() {
        val addressVolumeInMap = buildAddressVolumeInMap()
        context!!.forward(endOfTick.toString(), addressVolumeInMap)
        context!!.commit()
    }

    private fun slideTickForward(timestamp: BigInteger) {
        while (notInTick(timestamp)) {
            val firstBlockAddressVolumeIn = blockNumberAddressVolumeInStore!!.get(firstBlockNumber)
            removeBlockEntriesFromAddressVolumeInStore(firstBlockAddressVolumeIn)
            blockNumberAddressVolumeInStore!!.delete(firstBlockNumber)

            setFirstBlockNumber(firstBlockNumber!! + 1)

            val firstBlockTimestamp = blockNumberAddressVolumeInStore!!
                    .get(firstBlockNumber)
                    .getAddressFeatureOrDefault("timestamp", "-1")
                    .toBigInteger()
            setEndOfTick(firstBlockTimestamp)
        }
    }

    private fun setLastProcessedBlock(blockNumber: String) {
        synchronizationStore!!.put("lastProcessedBlockNumber", blockNumber)
    }

    private fun buildAddressVolumeInMap(): AddressFeature.AddressFeatureMap {
        val builder = AddressFeature.AddressFeatureMap.newBuilder()
        addressVolumeInStore!!.all().forEach { addressVolumeIn ->
            builder.putAddressFeature(addressVolumeIn.key, addressVolumeIn.value)
        }
        return builder.build()
    }

    private fun extract(block: Messages.Block) {
        accountForGas(block)
        extractAddressVolumeInFromTraces(block)
    }

    private fun accountForGas(block: Messages.Block) {
        block.transactionsList.forEach { transaction ->
            addToStores(block.author, VolumeInCalculator.multiply(transaction.receipt.gasUsed, transaction.gasPrice))
        }
    }

    private fun extractAddressVolumeInFromTraces(block: Messages.Block) {
        val traces = block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
        traces.forEach { trace ->
            when (trace.type) {
                "call" -> addToStores(trace.call.to, trace.call.value)
                "suicide" -> addToStores(trace.suicide.refundAddress, trace.suicide.balance)
                "create" -> addToStores(trace.result.address, trace.create.value)
                "reward" -> addToStores(trace.reward.author, trace.reward.value)
            }
        }
    }

    private fun addToStores(address: String, amount: String) {
        addToAddressVolumeInStore(address, amount)
        addToBlockNumberAddressVolumeInStore(address, amount)
    }

    private fun addToAddressVolumeInStore(address: String, amount: String) {
        val previousVolumeIn = addressVolumeInStore!!.get(address)
        if (previousVolumeIn.isNullOrEmpty()) {
            addressVolumeInStore!!.put(address, amount)
        } else {
            addressVolumeInStore!!.put(address, VolumeInCalculator.sum(amount, previousVolumeIn))
        }
    }

    private fun addToBlockNumberAddressVolumeInStore(address: String, amount: String) {
        val builder = blockNumberAddressVolumeInStore!!.get(currentBlockNumber).toBuilder()
        val previousVolumeIn = builder.getAddressFeatureOrDefault(address, "-1")
        if (previousVolumeIn == "-1") {
            builder.putAddressFeature(address, amount)
        } else {
            builder.putAddressFeature(address, VolumeInCalculator.sum(amount, previousVolumeIn))
        }
        blockNumberAddressVolumeInStore!!.put(currentBlockNumber, builder.build())
    }

    private fun removeBlockEntriesFromAddressVolumeInStore(firstBlockAddressVolumeIn: AddressFeature.AddressFeatureMap) {
        firstBlockAddressVolumeIn.addressFeatureMap.forEach { address, volumeIn ->
            if (address == "timestamp") return@forEach
            val previousVolumeIn = addressVolumeInStore!!.get(address)
            addressVolumeInStore!!.put(address, VolumeInCalculator.sum("-" + volumeIn, previousVolumeIn))
        }
    }
}

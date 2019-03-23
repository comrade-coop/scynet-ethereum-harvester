package kafka.transferLogsCount.stream.processor

import kafka.transferLogsCount.stream.messages.AddressFeature
import kafka.transferLogsCount.stream.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger

class TransferLogsCountProcessor() : Processor<String, Messages.Block> {

    private val ONE: Int = 1
    private val NEGATIVE_ONE: Int = -1
    private val TRANSFER_TOPIC = "0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"

    private var context: ProcessorContext? = null
    private var addressTransferLogsCountStore: KeyValueStore<String, String>? = null
    private var blockNumberAddressTransferLogsCountStore: KeyValueStore<Int, AddressFeature.AddressFeatureMap>? = null
    private var synchronizationStore: KeyValueStore<String, String>? = null
    private var endOfTick: BigInteger? = null
    private var firstBlockNumber: Int? = null
    private var lastProcessedBlockNumber: Int? = null
    private var currentBlockNumber: Int? = null

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

        this.addressTransferLogsCountStore = context.getStateStore("AddressTransferLogsCount") as KeyValueStore<String, String>
        this.blockNumberAddressTransferLogsCountStore = context.getStateStore("BlockNumberAddressTransferLogsCount") as KeyValueStore<Int, AddressFeature.AddressFeatureMap>
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
            commitTransferLogsCount()
            slideTickForward(block.timestamp.toBigInteger())
        }
        extractAddressTransferLogsCountFromTransactions(block)
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
        blockNumberAddressTransferLogsCountStore!!.put(currentBlockNumber, builder.build())
    }

    private fun notInTick(timestamp: BigInteger): Boolean {
        if (timestamp > endOfTick)
            return true
        return false
    }

    private fun commitTransferLogsCount() {
        val addressTransferLogsCountMap = buildAddressTransferLogsCountMap()
        context!!.forward(endOfTick.toString(), addressTransferLogsCountMap)
        context!!.commit()
    }

    private fun slideTickForward(timestamp: BigInteger) {
        while (notInTick(timestamp)) {
            val firstBlockAddressTransferLogsCount = blockNumberAddressTransferLogsCountStore!!.get(firstBlockNumber)
            removeBlockEntriesFromAddressTransferLogsCountStore(firstBlockAddressTransferLogsCount)
            blockNumberAddressTransferLogsCountStore!!.delete(firstBlockNumber)

            setFirstBlockNumber(firstBlockNumber!! + ONE)

            val firstBlockTimestamp = blockNumberAddressTransferLogsCountStore!!
                    .get(firstBlockNumber)
                    .getAddressFeatureOrDefault("timestamp", NEGATIVE_ONE.toString())
                    .toBigInteger()
            setEndOfTick(firstBlockTimestamp)
        }
    }

    private fun setLastProcessedBlock(blockNumber: String) {
        synchronizationStore!!.put("lastProcessedBlockNumber", blockNumber)
    }

    private fun buildAddressTransferLogsCountMap(): AddressFeature.AddressFeatureMap {
        val builder = AddressFeature.AddressFeatureMap.newBuilder()
        addressTransferLogsCountStore!!.all().forEach { addressTransferLogsCount ->
            builder.putAddressFeature(addressTransferLogsCount.key, addressTransferLogsCount.value)
        }
        return builder.build()
    }

    private fun extractAddressTransferLogsCountFromTransactions(block: Messages.Block) {
        block.transactionsList.forEach { transaction ->
            transaction.receipt.logsList.forEach { log ->
                if (isTransferLog(log)) {
                    addToStores(transaction.to)
                }
            }
        }
    }

    private fun isTransferLog(log: Messages.Log): Boolean {
        return TRANSFER_TOPIC.equals(log.topicsList[0])
    }

    private fun addToStores(address: String) {
        addToAddressTransferLogsCountStore(address)
        addToBlockNumberTransferLogsCountStore(address)
    }

    private fun addToAddressTransferLogsCountStore(address: String) {
        val previousTransferLogsCount = addressTransferLogsCountStore!!.get(address)
        if (previousTransferLogsCount.isNullOrEmpty()) {
            addressTransferLogsCountStore!!.put(address, ONE.toString())
        } else {
            addressTransferLogsCountStore!!.put(address, TransferLogsCountCalculator.increaseByOne(previousTransferLogsCount))
        }
    }

    private fun addToBlockNumberTransferLogsCountStore(address: String) {
        val builder = blockNumberAddressTransferLogsCountStore!!.get(currentBlockNumber).toBuilder()
        val previousTransferLogsCount = builder.getAddressFeatureOrDefault(address, NEGATIVE_ONE.toString())
        if (previousTransferLogsCount == NEGATIVE_ONE.toString()) {
            builder.putAddressFeature(address, ONE.toString())
        } else {
            builder.putAddressFeature(address, TransferLogsCountCalculator.increaseByOne(previousTransferLogsCount))
        }
        blockNumberAddressTransferLogsCountStore!!.put(currentBlockNumber, builder.build())
    }

    private fun removeBlockEntriesFromAddressTransferLogsCountStore(firstBlockAddressTransferLogsCount: AddressFeature.AddressFeatureMap) {
        firstBlockAddressTransferLogsCount.addressFeatureMap.forEach { address, transferLogsCount ->
            if (address == "timestamp") return@forEach
            val previousTransferLogsCount = addressTransferLogsCountStore!!.get(address)
            addressTransferLogsCountStore!!.put(address, TransferLogsCountCalculator.subtract(previousTransferLogsCount, transferLogsCount))
        }
    }
}

package kafka.transferLogsNumber.stream.processor

import kafka.transferLogsNumber.stream.messages.AddressFeature
import kafka.transferLogsNumber.stream.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger

class TransferLogsNumberProcessor() : Processor<String, Messages.Block> {

    private val ONE: Int = 1
    private val NEGATIVE_ONE: Int = -1
    private val TRANSFER_TOPIC = "0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"

    private var context: ProcessorContext? = null
    private var addressTransferLogsNumberStore: KeyValueStore<String, String>? = null
    private var blockNumberAddressTransferLogsNumberStore: KeyValueStore<Int, AddressFeature.AddressFeatureMap>? = null
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

        this.addressTransferLogsNumberStore = context.getStateStore("AddressTransferLogsNumber") as KeyValueStore<String, String>
        this.blockNumberAddressTransferLogsNumberStore = context.getStateStore("BlockNumberAddressTransferLogsNumber") as KeyValueStore<Int, AddressFeature.AddressFeatureMap>
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
            commitTransferLogsNumber()
            slideTickForward(block.timestamp.toBigInteger())
        }
        extractAddressTransferLogsNumberFromTransactions(block)
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
        blockNumberAddressTransferLogsNumberStore!!.put(currentBlockNumber, builder.build())
    }

    private fun notInTick(timestamp: BigInteger): Boolean {
        if (timestamp > endOfTick)
            return true
        return false
    }

    private fun commitTransferLogsNumber() {
        val addressTransferLogsNumberMap = buildAddressTransferLogsNumberMap()
        context!!.forward(endOfTick.toString(), addressTransferLogsNumberMap)
        context!!.commit()
    }

    private fun slideTickForward(timestamp: BigInteger) {
        while (notInTick(timestamp)) {
            val firstBlockAddressTransferLogsNumber = blockNumberAddressTransferLogsNumberStore!!.get(firstBlockNumber)
            removeBlockEntriesFromAddressTransferLogsNumberStore(firstBlockAddressTransferLogsNumber)
            blockNumberAddressTransferLogsNumberStore!!.delete(firstBlockNumber)

            setFirstBlockNumber(firstBlockNumber!! + ONE)

            val firstBlockTimestamp = blockNumberAddressTransferLogsNumberStore!!
                    .get(firstBlockNumber)
                    .getAddressFeatureOrDefault("timestamp", NEGATIVE_ONE.toString())
                    .toBigInteger()
            setEndOfTick(firstBlockTimestamp)
        }
    }

    private fun setLastProcessedBlock(blockNumber: String) {
        synchronizationStore!!.put("lastProcessedBlockNumber", blockNumber)
    }

    private fun buildAddressTransferLogsNumberMap(): AddressFeature.AddressFeatureMap {
        val builder = AddressFeature.AddressFeatureMap.newBuilder()
        addressTransferLogsNumberStore!!.all().forEach { addressTransferLogsNumber ->
            builder.putAddressFeature(addressTransferLogsNumber.key, addressTransferLogsNumber.value)
        }
        return builder.build()
    }

    private fun extractAddressTransferLogsNumberFromTransactions(block: Messages.Block) {
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
        addToAddressTransferLogsNumberStore(address)
        addToBlockNumberTransferLogsNumberStore(address)
    }

    private fun addToAddressTransferLogsNumberStore(address: String) {
        val previousTransferLogsNumber = addressTransferLogsNumberStore!!.get(address)
        if (previousTransferLogsNumber.isNullOrEmpty()) {
            addressTransferLogsNumberStore!!.put(address, ONE.toString())
        } else {
            addressTransferLogsNumberStore!!.put(address, TransferLogsNumberCalculator.increaseByOne(previousTransferLogsNumber))
        }
    }

    private fun addToBlockNumberTransferLogsNumberStore(address: String) {
        val builder = blockNumberAddressTransferLogsNumberStore!!.get(currentBlockNumber).toBuilder()
        val previousTransferLogsNumber = builder.getAddressFeatureOrDefault(address, NEGATIVE_ONE.toString())
        if (previousTransferLogsNumber == NEGATIVE_ONE.toString()) {
            builder.putAddressFeature(address, ONE.toString())
        } else {
            builder.putAddressFeature(address, TransferLogsNumberCalculator.increaseByOne(previousTransferLogsNumber))
        }
        blockNumberAddressTransferLogsNumberStore!!.put(currentBlockNumber, builder.build())
    }

    private fun removeBlockEntriesFromAddressTransferLogsNumberStore(firstBlockAddressTransferLogsNumber: AddressFeature.AddressFeatureMap) {
        firstBlockAddressTransferLogsNumber.addressFeatureMap.forEach { address, transferLogsNumber ->
            if (address == "timestamp") return@forEach
            val previousTransferLogsNumber = addressTransferLogsNumberStore!!.get(address)
            addressTransferLogsNumberStore!!.put(address, TransferLogsNumberCalculator.subtract(previousTransferLogsNumber, transferLogsNumber))
        }
    }
}

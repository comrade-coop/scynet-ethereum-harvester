package kafka.ERC20Transfers.stream.processor

import harvester.common.messages.AddressFeature
import harvester.common.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger

class ERC20TransfersProcessor() : Processor<String, Messages.Block> {

    private val ONE: Int = 1
    private val NEGATIVE_ONE: Int = -1
    private val TRANSFER_TOPIC = "0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"

    private var context: ProcessorContext? = null
    private var addressERC20TransfersStore: KeyValueStore<String, String>? = null
    private var blockNumberAddressERC20TransfersStore: KeyValueStore<Int, AddressFeature.AddressFeatureMap>? = null
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

        this.addressERC20TransfersStore = context.getStateStore("AddressERC20Transfers") as KeyValueStore<String, String>
        this.blockNumberAddressERC20TransfersStore = context.getStateStore("BlockNumberAddressERC20Transfers") as KeyValueStore<Int, AddressFeature.AddressFeatureMap>
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
            commitERC20Transfers()
            slideTickForward(block.timestamp.toBigInteger())
        }
        extractAddressERC20TransfersFromTransactions(block)
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
        blockNumberAddressERC20TransfersStore!!.put(currentBlockNumber, builder.build())
    }

    private fun notInTick(timestamp: BigInteger): Boolean {
        if (timestamp > endOfTick)
            return true
        return false
    }

    private fun commitERC20Transfers() {
        val addressERC20TransfersNumberMap = buildAddressERC20TransfersNumberMap()
        context!!.forward(endOfTick.toString(), addressERC20TransfersNumberMap)
        context!!.commit()
    }

    private fun slideTickForward(timestamp: BigInteger) {
        while (notInTick(timestamp)) {
            val firstBlockAddressERC20TransfersNumber = blockNumberAddressERC20TransfersStore!!.get(firstBlockNumber)
            removeBlockEntriesFromAddressERC20TransfersStore(firstBlockAddressERC20TransfersNumber)
            blockNumberAddressERC20TransfersStore!!.delete(firstBlockNumber)

            setFirstBlockNumber(firstBlockNumber!! + ONE)

            val firstBlockTimestamp = blockNumberAddressERC20TransfersStore!!
                    .get(firstBlockNumber)
                    .getAddressFeatureOrDefault("timestamp", NEGATIVE_ONE.toString())
                    .toBigInteger()
            setEndOfTick(firstBlockTimestamp)
        }
    }

    private fun setLastProcessedBlock(blockNumber: String) {
        synchronizationStore!!.put("lastProcessedBlockNumber", blockNumber)
    }

    private fun buildAddressERC20TransfersNumberMap(): AddressFeature.AddressFeatureMap {
        val builder = AddressFeature.AddressFeatureMap.newBuilder()
        addressERC20TransfersStore!!.all().forEach { addressERC20Transfers ->
            builder.putAddressFeature(addressERC20Transfers.key, addressERC20Transfers.value)
        }
        return builder.build()
    }

    private fun extractAddressERC20TransfersFromTransactions(block: Messages.Block) {
        block.transactionsList.forEach { transaction ->
            transaction.receipt.logsList.forEach { log ->
                if (isERC20Transfer(log)) {
                    addToStores(transaction.to)
                }
            }
        }
    }

    private fun isERC20Transfer(log: Messages.Log): Boolean {
        return TRANSFER_TOPIC.equals(log.topicsList[0])
    }

    private fun addToStores(address: String) {
        addToAddressERC20TransfersStore(address)
        addToBlockNumberERC20TransfersStore(address)
    }

    private fun addToAddressERC20TransfersStore(address: String) {
        val previousERC20TransfersNumber = addressERC20TransfersStore!!.get(address)
        if (previousERC20TransfersNumber.isNullOrEmpty()) {
            addressERC20TransfersStore!!.put(address, ONE.toString())
        } else {
            addressERC20TransfersStore!!.put(address, ERC20TransfersCalculator.increaseByOne(previousERC20TransfersNumber))
        }
    }

    private fun addToBlockNumberERC20TransfersStore(address: String) {
        val builder = blockNumberAddressERC20TransfersStore!!.get(currentBlockNumber).toBuilder()
        val previousERCTransfersNumber = builder.getAddressFeatureOrDefault(address, NEGATIVE_ONE.toString())
        if (previousERCTransfersNumber == NEGATIVE_ONE.toString()) {
            builder.putAddressFeature(address, ONE.toString())
        } else {
            builder.putAddressFeature(address, ERC20TransfersCalculator.increaseByOne(previousERCTransfersNumber))
        }
        blockNumberAddressERC20TransfersStore!!.put(currentBlockNumber, builder.build())
    }

    private fun removeBlockEntriesFromAddressERC20TransfersStore(firstBlockAddressERC20Transfers: AddressFeature.AddressFeatureMap) {
        firstBlockAddressERC20Transfers.addressFeatureMap.forEach { address, ERC20TransfersNumber ->
            if (address == "timestamp") return@forEach
            val previousERC20TranfersNumber = addressERC20TransfersStore!!.get(address)
            addressERC20TransfersStore!!.put(address, ERC20TransfersCalculator.subtract(previousERC20TranfersNumber, ERC20TransfersNumber))
        }
    }
}

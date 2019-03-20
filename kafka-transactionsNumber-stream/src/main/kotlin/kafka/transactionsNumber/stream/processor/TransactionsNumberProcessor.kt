package kafka.transactionsNumber.stream.processor

import org.apache.kafka.streams.processor.Processor
import kafka.transactionsNumber.stream.messages.*
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger

class TransactionsNumberProcessor(): Processor<String, Messages.Block> {

    private var context: ProcessorContext? = null
    private var addressTransactionsNumberStore: KeyValueStore<String, String>? = null
    private var blockNumberAddressTransactionsNumberStore: KeyValueStore<Int, AddressFeature.AddressFeatureMap>? = null
    private var synchronizationStore: KeyValueStore<String, String>? = null
    private var endOfTick: BigInteger? = null
    private var firstBlockNumber: Int? = null
    private var lastProcessedBlockNumber: Int? = null
    private var currentBlockNumber: Int? = null

    override fun process(blockNumber: String, block: Messages.Block) {
        try {
            process(block)
            println(blockNumber)
        } catch (e: Exception){
            // TODO use logger for this
            println("Exception occurred: $e while processing block: $blockNumber")
        }
    }

    override fun init(context: ProcessorContext) {
        this.context = context

        this.addressTransactionsNumberStore = context.getStateStore("AddressTransactionsNumber") as KeyValueStore<String, String>
        this.blockNumberAddressTransactionsNumberStore = context.getStateStore("BlockNumberAddressTransactionsNumber") as KeyValueStore<Int, AddressFeature.AddressFeatureMap>
        this.synchronizationStore = context.getStateStore("SynchronizationStore") as KeyValueStore<String, String>

        val firstBlockNumberString = synchronizationStore!!.get("firstBlockNumber")
        firstBlockNumber = if (firstBlockNumberString.isNullOrEmpty()) -1 else firstBlockNumberString.toInt()

        val endOfTickString = synchronizationStore!!.get("endOfTick")
        endOfTick = if (endOfTickString.isNullOrEmpty()) BigInteger.valueOf(-1) else endOfTickString.toBigInteger()

        val lastProcessedBlockNumberString = synchronizationStore!!.get("lastProcessedBlockNumber")
        lastProcessedBlockNumber = if(lastProcessedBlockNumberString.isNullOrEmpty()) -1 else lastProcessedBlockNumberString.toInt()
    }

    override fun close() {
    }

    private fun process(block: Messages.Block){
        val blockNumber = block.number.toInt()
        if(processed(blockNumber)){
            return
        }
        if(notSetEndOfTick()){
            setEndOfTick(block.timestamp.toBigInteger())
            setFirstBlockNumber(blockNumber)
        }
        addAddressFeatureBuilderWithTimestampForBlock(block)

        if (notInTick(block.timestamp.toBigInteger())) {
            commitTransactionsNumber()
            slideTickForward(block.timestamp.toBigInteger())
        }
        extract(block)
        setLastProcessedBlock(blockNumber.toString())
    }

    private fun processed(blockNumber: Int): Boolean{
        if(blockNumber <= lastProcessedBlockNumber!!){
            return true
        }
        return false
    }

    private fun notSetEndOfTick(): Boolean {
        if (endOfTick == BigInteger.valueOf(-1))
            return true
        return false
    }

    private fun setEndOfTick(timestamp: BigInteger){
        endOfTick = timestamp + BigInteger.valueOf(3600)
        synchronizationStore!!.put("endOfTick", endOfTick.toString())
    }

    private fun setFirstBlockNumber(blockNumber: Int){
        firstBlockNumber = blockNumber
        synchronizationStore!!.put("firstBlockNumber", firstBlockNumber.toString())
    }

    private fun addAddressFeatureBuilderWithTimestampForBlock(block: Messages.Block){
        currentBlockNumber = block.number.toInt()
        val builder = AddressFeature.AddressFeatureMap.newBuilder().putAddressFeature("timestamp", block.timestamp)
        blockNumberAddressTransactionsNumberStore!!.put(currentBlockNumber, builder.build())
    }

    private fun notInTick(timestamp: BigInteger): Boolean{
        if(timestamp > endOfTick)
            return true
        return false
    }

    private fun commitTransactionsNumber(){
        val addressTransactionsNumberMap = buildAddressTransactionsNumberMap()
        context!!.forward(endOfTick.toString(), addressTransactionsNumberMap)
        context!!.commit()
    }

    private fun slideTickForward(timestamp:BigInteger){
        while (notInTick(timestamp)) {
            val firstBlockAddressTransactionsNumber = blockNumberAddressTransactionsNumberStore!!.get(firstBlockNumber)
            removeBlockEntriesFromAddressTransactionsNumberStore(firstBlockAddressTransactionsNumber)
            blockNumberAddressTransactionsNumberStore!!.delete(firstBlockNumber)

            setFirstBlockNumber(firstBlockNumber!! + 1)

            val firstBlockTimestamp = blockNumberAddressTransactionsNumberStore!!
                    .get(firstBlockNumber)
                    .getAddressFeatureOrDefault("timestamp", "-1")
                    .toBigInteger()
            setEndOfTick(firstBlockTimestamp)
        }
    }

    private fun setLastProcessedBlock(blockNumber: String){
        synchronizationStore!!.put("lastProcessedBlockNumber", blockNumber)
    }

    private fun buildAddressTransactionsNumberMap(): AddressFeature.AddressFeatureMap{
        val builder = AddressFeature.AddressFeatureMap.newBuilder()
        addressTransactionsNumberStore!!.all().forEach { addressTransactionsNumber ->
            builder.putAddressFeature(addressTransactionsNumber.key, addressTransactionsNumber.value)
        }
        return builder.build()
    }

    private fun extract(block: Messages.Block) {
        extractAddressTransactionsNumberFromTraces(block)
    }

    private fun extractAddressTransactionsNumberFromTraces(block: Messages.Block) {
        val traces = getTraces(block)
        traces.forEach { trace ->
            when (trace.type) {
                "reward"-> addToStores(trace.reward.author)
                "call" -> {
                    addToStores(trace.call.from)
                    addToStores(trace.call.to)
                }
                "suicide" -> {
                    addToStores(trace.suicide.address)
                    addToStores(trace.suicide.refundAddress)

                }
                "create" ->{
                    addToStores(trace.create.from)
                    addToStores(trace.result.address)
                }
            }
        }
    }

    private fun getTraces(block: Messages.Block): List<Messages.Trace>{
        return block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
    }

    private fun addToStores(address: String) {
        addToAddressTransactionNumberStore(address)
        addToBlockNumberTransactionsNumberStore(address)
    }

    private fun addToAddressTransactionNumberStore(address: String) {
        val previousTransactionsNumber = addressTransactionsNumberStore!!.get(address)
        if (previousTransactionsNumber.isNullOrEmpty()) {
            addressTransactionsNumberStore!!.put(address, "1")
        } else {
            addressTransactionsNumberStore!!.put(address, TransactionsNumberCalculator.sum("1", previousTransactionsNumber))
        }
    }

    private fun addToBlockNumberTransactionsNumberStore(address: String) {
        val builder = blockNumberAddressTransactionsNumberStore!!.get(currentBlockNumber).toBuilder()
        val previousTransactionsNumber = builder.getAddressFeatureOrDefault(address, "-1")
        if (previousTransactionsNumber == "-1") {
            builder.putAddressFeature(address, "1")
        } else {
            builder.putAddressFeature(address, TransactionsNumberCalculator.sum("1", previousTransactionsNumber))
        }
        blockNumberAddressTransactionsNumberStore!!.put(currentBlockNumber, builder.build())
    }

    private fun removeBlockEntriesFromAddressTransactionsNumberStore(firstBlockAddressTransactionsNumber: AddressFeature.AddressFeatureMap){
        firstBlockAddressTransactionsNumber.addressFeatureMap.forEach { address, transactionsNumber ->
            if(address == "timestamp") return@forEach
            val previousTransactionsNumber = addressTransactionsNumberStore!!.get(address)
            addressTransactionsNumberStore!!.put(address, TransactionsNumberCalculator.sum("-" + transactionsNumber, previousTransactionsNumber))
        }
    }
}

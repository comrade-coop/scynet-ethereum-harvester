package kafka.volumeOut.stream.processor

import org.apache.kafka.streams.processor.Processor
import kafka.volumeOut.stream.messages.*
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger

class VolumeOutProcessor(): Processor<String, Messages.Block> {

    private var context: ProcessorContext? = null
    private var addressVolumeOutStore: KeyValueStore<String, String>? = null
    private var blockNumberAddressVolumeOutStore: KeyValueStore<Int, AddressFeature.AddressFeatureMap>? = null
    private var synchronizationStore: KeyValueStore<String, String>? = null
    private var endOfTick: BigInteger? = null
    private var firstBlockNumber: Int? = null
    private var lastProcessedBlockNumber: Int? = null
    private var currentBlockNumber: Int? = null

    override fun process(blockNumber: String, block: Messages.Block) {
        skipIfProcessed(blockNumber.toInt())
        if(notSetEndOfTick()){
            setEndOfTick(block.timestamp.toBigInteger())
            setFirstBlockNumber(blockNumber.toInt())
        }
        println(blockNumber)
        currentBlockInitialization(block)

        if (notInTick(block.timestamp.toBigInteger())) {
            commitVolumeOut()
            slideTickForward(block.timestamp.toBigInteger())
        }
        extract(block)
        setLastProcessedBlock(blockNumber)
    }

    override fun init(context: ProcessorContext) {
        this.context = context

        this.addressVolumeOutStore = context.getStateStore("AddressVolumeOut") as KeyValueStore<String, String>
        this.blockNumberAddressVolumeOutStore = context.getStateStore("BlockNumberAddressVolumeOut") as KeyValueStore<Int, AddressFeature.AddressFeatureMap>
        this.synchronizationStore = context.getStateStore("SynchronizationStore") as KeyValueStore<String, String>

        val fbn = synchronizationStore!!.get("firstBlockNumber")
        firstBlockNumber = if (fbn.isNullOrEmpty()) -1 else fbn.toInt()

        val eot = synchronizationStore!!.get("endOfTick")
        endOfTick = if (eot.isNullOrEmpty()) BigInteger.valueOf(-1) else eot.toBigInteger()

        val lpbn = synchronizationStore!!.get("lastProcessedBlockNumber")
        lastProcessedBlockNumber = if(lpbn.isNullOrEmpty()) -1 else lpbn.toInt()
    }

    override fun close() {
    }

    private fun skipIfProcessed(blockNumber: Int){
        if(blockNumber.toInt() <= lastProcessedBlockNumber!!){
            println("already processed")
            return
        }
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
        firstBlockNumber = blockNumber.toInt()
        synchronizationStore!!.put("firstBlockNumber", firstBlockNumber.toString())
    }


    private fun currentBlockInitialization(block: Messages.Block){
        currentBlockNumber = block.number.toInt()
        val builder = AddressFeature.AddressFeatureMap.newBuilder().putAddressFeature("timestamp", block.timestamp)
        blockNumberAddressVolumeOutStore!!.put(currentBlockNumber, builder.build())
    }

    private fun notInTick(timestamp: BigInteger): Boolean{
        if(timestamp > endOfTick)
            return true
        return false
    }

    private fun commitVolumeOut(){
        val addressVolumeOutMap = buildAddressVolumeOutMap()
        context!!.forward(endOfTick.toString(), addressVolumeOutMap)
        context!!.commit()
    }

    private fun slideTickForward(timestamp:BigInteger){
        while (notInTick(timestamp)) {
            val firstBlockAddressVolumeOut = blockNumberAddressVolumeOutStore!!.get(firstBlockNumber)
            removeBlockEntriesFromAddressVolumeOutStore(firstBlockAddressVolumeOut)
            blockNumberAddressVolumeOutStore!!.delete(firstBlockNumber)

            setFirstBlockNumber(firstBlockNumber!! + 1)

            val firstBlockTimestamp = blockNumberAddressVolumeOutStore!!
                    .get(firstBlockNumber)
                    .getAddressFeatureOrDefault("timestamp", "-1")
                    .toBigInteger()
            setEndOfTick(firstBlockTimestamp)
        }
    }

    private fun setLastProcessedBlock(blockNumber: String){
        synchronizationStore!!.put("lastProcessedBlockNumber", blockNumber)
    }

    private fun buildAddressVolumeOutMap(): AddressFeature.AddressFeatureMap{
        val builder = AddressFeature.AddressFeatureMap.newBuilder()
        addressVolumeOutStore!!.all().forEach {addressVolumeOut ->
            builder.putAddressFeature(addressVolumeOut.key, addressVolumeOut.value)
        }
        return builder.build()
    }

    private fun extract(block: Messages.Block) {
        accountForGas(block)
        addressVolumeOutFromTraces(block)
    }

    private fun accountForGas(block: Messages.Block) {
        block.transactionsList.forEach { transaction ->
            addToStores(transaction.from, VolumeOutCalculator.multiply(transaction.receipt.gasUsed, transaction.gasPrice))
        }
    }

    private fun addressVolumeOutFromTraces(block: Messages.Block) {
        val traces = block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
        traces.forEach { trace ->
            when (trace.type) {
                "call" -> {
                    addToStores(trace.call.from, trace.call.value)
                }
                "suicide" -> addToStores(trace.suicide.address, trace.suicide.balance)
                "create" -> addToStores(trace.create.from, trace.create.value)
            }
        }
    }

    private fun addToStores(address: String, amount: String) {
        addToAddressVolumeOutStore(address, amount)
        addToBlockNumberAddressVolumeOutStore(address, amount)
    }

    private fun addToAddressVolumeOutStore(address: String, amount: String) {
        val previousVolumeOut = addressVolumeOutStore!!.get(address)
        if (previousVolumeOut.isNullOrEmpty()) {
            addressVolumeOutStore!!.put(address, amount)
        } else {
            addressVolumeOutStore!!.put(address, VolumeOutCalculator.sum(amount, previousVolumeOut))
        }
    }

    private fun addToBlockNumberAddressVolumeOutStore(address: String, amount: String) {
        val builder = blockNumberAddressVolumeOutStore!!.get(currentBlockNumber).toBuilder()
        val previousVolumeOut = builder.getAddressFeatureOrDefault(address, "-1")
        if (previousVolumeOut == "-1") {
            builder.putAddressFeature(address, amount)
        } else {
            builder.putAddressFeature(address, VolumeOutCalculator.sum(amount, previousVolumeOut))
        }
        blockNumberAddressVolumeOutStore!!.put(currentBlockNumber, builder.build())
    }

    private fun removeBlockEntriesFromAddressVolumeOutStore(firstBlockAddressVolumeOut: AddressFeature.AddressFeatureMap){
        firstBlockAddressVolumeOut.addressFeatureMap.forEach { address, volumeOut ->
            if(address == "timestamp") return@forEach
            val previousVolumeOut = addressVolumeOutStore!!.get(address)
            addressVolumeOutStore!!.put(address, VolumeOutCalculator.sum("-" + volumeOut, previousVolumeOut))
        }
    }
}
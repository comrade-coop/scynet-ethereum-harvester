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
    private var endOfTick: BigInteger? = null
    private var firstBlockNumber: Int? = null
    private var currentBlockNumber: Int? = null
    private var lastProcessedBlockNumber: Int? = null

    override fun process(blockNumber: String, block: Messages.Block) {


        if (endOfTick == BigInteger.valueOf(-1)) {
            endOfTick = block.timestamp.toBigInteger() + BigInteger.valueOf(3600)
            addressVolumeOutStore!!.put("endOfTick", endOfTick.toString())
            firstBlockNumber = blockNumber.toInt()
            addressVolumeOutStore!!.put("firstBlockNumber", firstBlockNumber.toString())
            lastProcessedBlockNumber
        }

        if(blockNumber.toInt() < lastProcessedBlockNumber!!){
            print("already processed")
            return
        }
        println(blockNumber)
        currentBlockInitialization(block)

        if (block.timestamp.toBigInteger() > endOfTick) {
            val addressVolumeOutMap = buildAddressVolumeOutMap()
            context!!.forward(endOfTick.toString(), addressVolumeOutMap)
            context!!.commit()

            while (block.timestamp.toBigInteger() > endOfTick) {
                val firstBlockAddressVolumeOut = blockNumberAddressVolumeOutStore!!.get(firstBlockNumber)
                blockNumberAddressVolumeOutStore!!.delete(firstBlockNumber)
                removeBlockEntriesFromAddressVolumeOutStore(firstBlockAddressVolumeOut)
                firstBlockNumber = firstBlockNumber!! + 1
                endOfTick = blockNumberAddressVolumeOutStore!!
                        .get(firstBlockNumber)
                        .getAddressFeatureOrDefault("timestamp", "-1")
                        .toBigInteger() + BigInteger.valueOf(3600)
            }
        }

        extract(block)
        addressVolumeOutStore!!.put("lastProcessedBlockNumber", blockNumber)

    }

    override fun init(context: ProcessorContext) {
        this.context = context

        this.addressVolumeOutStore = context.getStateStore("AddressVolumeOut") as KeyValueStore<String, String>
        this.blockNumberAddressVolumeOutStore = context.getStateStore("BlockNumberAddressVolumeOut") as KeyValueStore<Int, AddressFeature.AddressFeatureMap>

        val fbn = addressVolumeOutStore!!.get("firstBlockNumber")
        firstBlockNumber = if (fbn.isNullOrEmpty()) -1 else fbn.toInt()

        val eot = addressVolumeOutStore!!.get("endOfTick")
        endOfTick = if (eot.isNullOrEmpty()) BigInteger.valueOf(-1) else eot.toBigInteger()

        val lpbn = addressVolumeOutStore!!.get("lastProcessedBlockNumber")
        lastProcessedBlockNumber = if(lpbn.isNullOrEmpty()) -1 else lpbn.toInt()
    }

    override fun close() {
    }

    private fun currentBlockInitialization(block: Messages.Block){
        currentBlockNumber = block.number.toInt()
        val builder = AddressFeature.AddressFeatureMap.newBuilder().putAddressFeature("timestamp", block.timestamp)
        blockNumberAddressVolumeOutStore!!.put(currentBlockNumber, builder.build())
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
                //"reward" -> addToStores(trace.reward.author, trace.reward.value)
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
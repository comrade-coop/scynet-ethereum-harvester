package kafka.balanceTick.stream.processor

import harvester.common.messages.AddressFeature
import harvester.common.messages.Messages
import harvester.common.processor.FeatureCalculator
import harvester.common.processor.TickFeatureProcessor
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger

class BalanceTickProcessor: TickFeatureProcessor("3600") {
    private var addressFeatureStore: KeyValueStore<String, String>? = null
    private var blockNumberAddressFeatureStore: KeyValueStore<Int, AddressFeature.AddressFeatureMap>? = null
    private var addressOccurrencesInTick: KeyValueStore<String, Int>? = null
    private val addressesInBlock: HashSet<String> = HashSet()

    override fun addFeatureBuilderWithTimestampForBlock(block: Messages.Block) {
        currentBlockNumber = block.number.toInt()
        val builder = AddressFeature.AddressFeatureMap.newBuilder().putAddressFeature("timestamp", block.timestamp)
        blockNumberAddressFeatureStore!!.put(currentBlockNumber, builder.build())
    }

    override fun buildFeatureMap(): AddressFeature.AddressFeatureMap {
        val builder = AddressFeature.AddressFeatureMap.newBuilder()
        val addressesInTick = addressOccurrencesInTick!!.all()
        addressesInTick.forEach{ addressOccurance ->
            val balance = addressFeatureStore!!.get(addressOccurance.key)
            builder.putAddressFeature(addressOccurance.key, balance)
        }
        addressesInTick.close()
        return builder.build()
    }

    override fun extract(block: Messages.Block) {
        //accountForGas(block)
        addressBalanceFromTraces(block)

        addressesInBlock.forEach { address ->
            incrementOccurrences(address)
        }
    }

    override fun initStores() {
        this.addressFeatureStore = context!!.getStateStore("AddressFeature") as KeyValueStore<String, String>
        this.blockNumberAddressFeatureStore = context!!.getStateStore("BlockNumberAddressFeature") as KeyValueStore<Int, AddressFeature.AddressFeatureMap>
        this.addressOccurrencesInTick = context!!.getStateStore("AddressOccurrencesInTick") as KeyValueStore<String, Int>

    }

    override fun slideTickForward() {
        while (notInTick(getFirstBlockTimestamp())) {
            val firstBlockAddressFeature = blockNumberAddressFeatureStore!!.get(firstBlockNumber)
            removeBlockEntriesFromFeatureStore(firstBlockAddressFeature)
            blockNumberAddressFeatureStore!!.delete(firstBlockNumber)
            setFirstBlockNumber(firstBlockNumber!! + ONE)
        }
    }

    private fun getFirstBlockTimestamp(): BigInteger {
        return blockNumberAddressFeatureStore!!
                .get(firstBlockNumber)
                .getAddressFeatureOrDefault("timestamp", NEGATIVE_ONE.toString())
                .toBigInteger()
    }

    private fun removeBlockEntriesFromFeatureStore(firstBlockAddressFeature: AddressFeature.AddressFeatureMap) {
        firstBlockAddressFeature.addressFeatureMap.forEach { address, feature ->
            if (address == "timestamp") return@forEach
            decrementOccurrences(address)
        }
    }

    private fun accountForGas(block: Messages.Block) {

        var rewardForBlockAuthor = "0"
        block.transactionsList.forEach { transaction ->
            addToStores(transaction.from, "-" + FeatureCalculator.multiply(transaction.receipt.gasUsed, transaction.gasPrice))
            rewardForBlockAuthor = FeatureCalculator.sum(rewardForBlockAuthor, FeatureCalculator.multiply(transaction.receipt.gasUsed, transaction.gasPrice))
        }
        addToStores(block.author, rewardForBlockAuthor)
    }

    private fun addressBalanceFromTraces(block: Messages.Block){
        val traces = block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
        traces.forEach { trace ->
            when (trace.type) {
                "reward" ->{
                    addToStores(trace.reward.author, trace.reward.value)
                    addressesInBlock.add(trace.reward.author)
                }
                "call" -> {
                    addToStores(trace.call.from, "-" + trace.call.value)
                    addToStores(trace.call.to, trace.call.value)
                    addressesInBlock.add(trace.call.from)
                    addressesInBlock.add(trace.call.to)
                }
                "suicide" -> {
                    addToStores(trace.suicide.refundAddress, trace.suicide.balance)
                    addToStores(trace.suicide.address, "-" + trace.suicide.balance)
                    addressesInBlock.add(trace.suicide.refundAddress)
                    addressesInBlock.add(trace.suicide.address)

                }
                "create" -> {
                    addToStores(trace.create.from,"-" + trace.create.value)
                    addToStores(trace.result.address, trace.create.value)
                    addressesInBlock.add(trace.create.from)
                    addressesInBlock.add(trace.result.address)
                }
            }
        }
    }

    private fun addToStores(address: String, amount: String){
        addToAddressFeatureStore(address, amount)
        addToBlockNumberAddressFeatureStore(address, amount)
    }

    private fun addToAddressFeatureStore(address: String, amount: String){
        val previousBalance = addressFeatureStore!!.get(address)
        if(previousBalance.isNullOrEmpty()){
            addressFeatureStore!!.put(address, amount)
        } else {
            addressFeatureStore!!.put(address, FeatureCalculator.sum(amount, previousBalance))
        }
    }

    private fun addToBlockNumberAddressFeatureStore(address: String, amount: String){
        val builder = blockNumberAddressFeatureStore!!.get(currentBlockNumber).toBuilder()
        val previousVolumeOut = builder.getAddressFeatureOrDefault(address, "-1")
        if (previousVolumeOut == "-1") {
            builder.putAddressFeature(address, amount)
            blockNumberAddressFeatureStore!!.put(currentBlockNumber, builder.build())
        }
    }

    private fun incrementOccurrences(address: String){
        val occurrences = addressOccurrencesInTick!!.get(address)
        if(occurrences == null){
            addressOccurrencesInTick!!.put(address, 1)
        }
        else{
            addressOccurrencesInTick!!.put(address, occurrences + 1)
        }
    }
    private fun decrementOccurrences(address: String){
        val occurrences = addressOccurrencesInTick!!.get(address)
        if(occurrences!! != 0){
            addressOccurrencesInTick!!.put(address, occurrences - 1)
        } else{
            addressOccurrencesInTick!!.delete(address)
        }
    }
}

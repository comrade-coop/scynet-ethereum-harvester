package kafka.lastSeen.stream.processor

import harvester.common.messages.AddressFeature
import harvester.common.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore

class LastSeenProcessor() : Processor<String, Messages.Block> {

    private var context: ProcessorContext? = null
    private var addressLastSeenStore: KeyValueStore<String, String>? = null
    private val currentAddresses: HashSet<String> = HashSet()
    private var lastProcessedBlock: Int? = null

    override fun process(blockNumber: String, block: Messages.Block) {

        if(lastProcessedBlock != null && lastProcessedBlock != blockNumber.toInt() - 1){
            println()
        }

        currentAddresses.clear()
        extract(block)

        val addressFeatureMap  = buildAddressFeatureMap(block.timestamp)
        println(blockNumber)
        context!!.forward(blockNumber, addressFeatureMap)
        context!!.commit()
        lastProcessedBlock = blockNumber.toInt()
    }

    override fun init(context: ProcessorContext) {
        this.context = context

        this.addressLastSeenStore = context.getStateStore("AddressFeature") as KeyValueStore<String, String>
    }

    override fun close() {
    }

    fun buildAddressFeatureMap(blockTimestamp: String): AddressFeature.AddressFeatureMap{
        val addressFeatureBuilder = AddressFeature.AddressFeatureMap.newBuilder()
        currentAddresses.forEach{ address ->
            addressFeatureBuilder.putAddressFeature(address, blockTimestamp)
        }
        return addressFeatureBuilder.build()
    }

    private fun extract(block: Messages.Block){
        val traces = getTraces(block)

        traces.forEach{
            trace ->
            when(trace.type){

                "reward" -> {
                    addressLastSeenStore!!.put(trace.reward.author, block.timestamp)
                    currentAddresses.add(trace.reward.author)
                }
                "call" -> {
                    addressLastSeenStore!!.put(trace.call.from, block.timestamp)
                    addressLastSeenStore!!.put(trace.call.to, block.timestamp)
                    currentAddresses.add(trace.call.from)
                    currentAddresses.add(trace.call.to)
                }
                "suicide" -> {
                    addressLastSeenStore!!.put(trace.suicide.refundAddress, block.timestamp)
                    addressLastSeenStore!!.put(trace.suicide.address, block.timestamp)
                    currentAddresses.add(trace.suicide.refundAddress)
                    currentAddresses.add(trace.suicide.address)

                }
                "create" ->{
                    addressLastSeenStore!!.put(trace.create.from, block.timestamp)
                    addressLastSeenStore!!.put(trace.result.address, block.timestamp)
                    currentAddresses.add(trace.create.from)
                    currentAddresses.add(trace.result.address)
                }
            }
        }
    }

    private fun getTraces(block: Messages.Block): List<Messages.Trace>{
        return block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
    }

}

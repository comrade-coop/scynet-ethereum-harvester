package kafka.lastSeen.stream.processor

import org.apache.kafka.streams.processor.Processor
import kafka.lastSeen.stream.messages.*
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore

class LastSeenProcessor() : Processor<String, Messages.Block> {

    private var context: ProcessorContext? = null
    private var addressLastSeenStore: KeyValueStore<String, String>? = null

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
        populateAddressLastSeenStore(block)

        val addressFeatureMap = buildAddressFeatureMap(block.timestamp)

        context!!.forward(blockNumber, addressFeatureMap)
        context!!.commit()
    }

    override fun init(context: ProcessorContext) {
        this.context = context

        this.addressLastSeenStore = context.getStateStore("LastSeen") as KeyValueStore<String, String>
    }

    override fun close() {
    }

    fun buildAddressFeatureMap(blockTimestamp: String): AddressFeature.AddressFeatureMap {
        val addressFeatureBuilder = AddressFeature.AddressFeatureMap.newBuilder()
        addressLastSeenStore!!.all().forEach { entry ->
            addressFeatureBuilder.putAddressFeature(entry.key, (blockTimestamp.toBigInteger() - entry.value.toBigInteger()).toString())
        }
        return addressFeatureBuilder.build()
    }

    private fun populateAddressLastSeenStore(block: Messages.Block) {
        val traces = getTraces(block)

        traces.forEach { trace ->
            when (trace.type) {
                "reward" -> addressLastSeenStore!!.put(trace.reward.author, block.timestamp)
                "call" -> {
                    addressLastSeenStore!!.put(trace.call.from, block.timestamp)
                    addressLastSeenStore!!.put(trace.call.to, block.timestamp)
                }
                "suicide" -> addressLastSeenStore!!.put(trace.suicide.refundAddress, block.timestamp)
                "create" -> addressLastSeenStore!!.put(trace.create.from, block.timestamp)
            }
        }
    }

    private fun getTraces(block: Messages.Block): List<Messages.Trace> {
        return block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
    }

}
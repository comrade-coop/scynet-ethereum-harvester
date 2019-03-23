package kafka.uniqueAccounts.stream.processor

import kafka.uniqueAccounts.stream.messages.AddressFeature
import kafka.uniqueAccounts.stream.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger

class UniqueAccountsProcessor : Processor<String, Messages.Block> {

    private val EXISTS = "1"
    private val NOT_EXISTS = "0"
    private val TOTAL_COUNT = "totalCount"
    private val ZERO = "0"

    private var context: ProcessorContext? = null
    private var blockNumberUniqueAccounts: KeyValueStore<Int, AddressFeature.AddressFeatureMap>? = null
    private var synchronizationStore: KeyValueStore<String, String>? = null

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

        extractUniqueAccounts(block)

        val addressFeatureBuilder = AddressFeature.AddressFeatureMap.newBuilder()
        addressFeatureBuilder.putAddressFeature(blockNumber, getTotalCount())

        context!!.forward(blockNumber, addressFeatureBuilder.build())
        context!!.commit()

        println("TOTAL COUNT: " + getTotalCount())
        println("BLOCK NUMBER: " + blockNumber)
    }

    override fun init(context: ProcessorContext) {
        this.context = context
        this.blockNumberUniqueAccounts = context.getStateStore("BlockNumberUniqueAccounts") as KeyValueStore<Int, AddressFeature.AddressFeatureMap>
        this.synchronizationStore = context.getStateStore("SynchronizationStore") as KeyValueStore<String, String>
    }

    override fun close() {
    }

    private fun getTotalCount(): String {
        return synchronizationStore!!.get(TOTAL_COUNT)
    }

    private fun extractUniqueAccounts(block: Messages.Block) {
        synchronizationStore!!.putIfAbsent(TOTAL_COUNT, ZERO)
        updateSynchronizationStore(block.author)
        extractUniqueAccountsFromTraces(block)
    }

    private fun extractUniqueAccountsFromTraces(block: Messages.Block) {
        val traces = block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
        traces.forEach { trace ->
            when (trace.type) {
                "reward" -> updateSynchronizationStore(trace.reward.author)
                "call" -> {
                    updateSynchronizationStore(trace.call.from)
                    updateSynchronizationStore(trace.call.to)
                }
                "suicide" -> updateSynchronizationStore(trace.suicide.refundAddress)
                "create" -> updateSynchronizationStore(trace.create.from)
            }
        }
    }

    private fun updateSynchronizationStore(address: String) {
        synchronizationStore!!.putIfAbsent(address, NOT_EXISTS)
        if (NOT_EXISTS.equals(synchronizationStore!!.get(address))) {
            synchronizationStore!!.put(address, EXISTS)
            updateTotalCount()
        }
    }

    private fun updateTotalCount() {
        val updatedTotalCount = getTotalCount()
                .toBigInteger()
                .add(BigInteger.ONE)
                .toString()
        synchronizationStore!!.put(TOTAL_COUNT, updatedTotalCount)
    }

}
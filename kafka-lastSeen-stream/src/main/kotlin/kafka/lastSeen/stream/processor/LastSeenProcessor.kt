package kafka.lastSeen.stream.processor

import org.apache.kafka.streams.processor.Processor
import kafka.lastSeen.stream.messages.*
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore

class LastSeenProcessor(private val addressLastSeenExtractor: LastSeenExtractor) : Processor<String, Messages.Block> {

    private var context: ProcessorContext? = null
    private var addressLastSeenStore: KeyValueStore<String, String>? = null
    private var addressLastSeen: HashMap<String, String>? = null
    private val firstBlockTimestamp: Long = 1438269973

    override fun process(blockNumber: String?, block: Messages.Block?) {
        addressLastSeen = addressLastSeenExtractor.extract(block!!)
        synchronizeAddressLastSeenAndStore()


        val addressLastSeenBuilder = AddressLastSeen.AddressLastSeenMap.newBuilder()
        addressLastSeen!!.forEach { entry ->
            addressLastSeenBuilder.putAddressLastSeen(entry.key, entry.value)
        }

        context!!.forward(blockNumber, addressLastSeenBuilder.build())
        context!!.commit()
    }

    override fun init(context: ProcessorContext) {
        this.context = context

        this.addressLastSeenStore = context.getStateStore("LastSeen") as KeyValueStore<String, String>
    }

    override fun close() {
    }

    private fun synchronizeAddressLastSeenAndStore() {
        addressLastSeen!!.forEach { address, timestamp ->
            val lastSeen = addressLastSeenStore!!.get(address)
            if(lastSeen.isNullOrEmpty()){
                val initialLastSeenInSeconds = timestamp.toLong() - firstBlockTimestamp
                addressLastSeenStore!!.put(address, initialLastSeenInSeconds.toString())
                addressLastSeen!!.put(address, initialLastSeenInSeconds.toString())
            } else {
                val updatedLastSeenInSeconds = timestamp.toLong() - lastSeen.toLong()
                addressLastSeenStore!!.put(address, updatedLastSeenInSeconds.toString())
                addressLastSeen!!.put(address, updatedLastSeenInSeconds.toString())
            }
        }
    }
}
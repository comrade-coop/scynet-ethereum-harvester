package kafka.lastSeen.stream.processor

import kafka.lastSeen.stream.messages.AddressLastSeen
import org.apache.kafka.streams.processor.Processor
import kafka.lastSeen.stream.messages.Messages
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore

class LastSeenProcessor(private val addressLastSeenExtractor: LastSeenExtractor): Processor<String, Messages.Block> {

    private var context: ProcessorContext? = null
    private var kvStore: KeyValueStore<String, String>? = null
    private var addressLastSeen: HashMap<String, String>? = null

    override fun process(blockNumber: String?, block: Messages.Block?) {
        addressLastSeen = addressLastSeenExtractor.extract(block!!)
        synchronizeAddressLastSeenAndStore()

        val addressLastSeenBuilder = AddressLastSeen.AddressLastSeenMap.newBuilder()
        addressLastSeen!!.forEach{ entry ->
            addressLastSeenBuilder.putAddressLastSeen(entry.key, entry.value)
        }

        context!!.forward(blockNumber, addressLastSeenBuilder.build())
        context!!.commit()
    }

    override fun init(context: ProcessorContext) {
        this.context = context

        this.kvStore = context.getStateStore("LastSeen") as KeyValueStore<String, String>
    }

    override fun close() {
    }

    private fun synchronizeAddressLastSeenAndStore(){
        addressLastSeen!!.forEach { address, timestamp ->
            val lastSeen = kvStore!!.get(address)
            if(lastSeen.isNullOrEmpty()){
                kvStore!!.put(address, timestamp)
            } else{
                kvStore!!.put(address, LastSeenAccumulator.update(lastSeen, timestamp))
            }
        }
    }
}
package kafka.lastSeen.stream.processor

import kafka.lastSeen.stream.messages.AddressLastSeen
import org.apache.kafka.streams.processor.Processor
import kafka.lastSeen.stream.messages.Messages
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger
import java.time.Instant

class LastSeenProcessor(private val addressLastSeenExtractor: LastSeenExtractor) : Processor<String, Messages.Block> {

    private var context: ProcessorContext? = null
    private var addressLastSeenStore: KeyValueStore<String, String>? = null
    private var addressLastSeen: HashMap<String, String>? = null

    override fun process(blockNumber: String?, block: Messages.Block?) {
        addressLastSeen = addressLastSeenExtractor.extract(block!!)
        val timestampNow = Instant.now().toEpochMilli() / 1000
        synchronizeAddressLastSeenStore(BigInteger.valueOf(timestampNow))

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

    private fun synchronizeAddressLastSeenStore(timestampNow: BigInteger) {
        addressLastSeen!!.forEach { address, transactionTimestamp ->
            val secondsSinceLastTransaction = timestampNow.subtract(BigInteger(transactionTimestamp)).toString()
            addressLastSeenStore!!.put(address, secondsSinceLastTransaction)
        }
    }
}
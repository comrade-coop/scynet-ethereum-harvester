package kafka.volumeOut.stream.processor

import org.apache.kafka.streams.processor.Processor
import kafka.volumeOut.stream.messages.*
import org.apache.kafka.streams.KeyValue
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore
import java.util.*

class VolumeOutProcessor(private val volumeOutExtractor: VolumeOutExtractor): Processor<String, Messages.Block> {

    private var context: ProcessorContext? = null
    private var addressVolumeOutStore: KeyValueStore<String, String>? = null
    private var addressVolumeOut: HashMap<String, String>? = null
    private var blocksInTick: Deque<KeyValue<String, Messages.Block>>? = null

    override fun process(blockNumber: String?, block: Messages.Block?) {

        println(blockNumber)
        addressVolumeOut = volumeOutExtractor.extract(block!!)
        synchronizeAddressVolumeOutAndStore()


        val addressFeatureBuilder = AddressFeature.AddressFeatureMap.newBuilder()
        addressVolumeOut!!.forEach { entry ->
            addressFeatureBuilder.putAddressFeature(entry.key, entry.value)
        }

        context!!.forward(blockNumber, addressFeatureBuilder.build())
        context!!.commit()
    }

    override fun init(context: ProcessorContext) {
        this.context = context

        this.addressVolumeOutStore = context.getStateStore("LastSeen") as KeyValueStore<String, String>
    }

    override fun close() {
    }

    private fun synchronizeAddressVolumeOutAndStore() {
        addressVolumeOut!!.forEach { address, volumeOut ->
            val initialVolumeOut = addressVolumeOutStore!!.get(address)
            if(initialVolumeOut.isNullOrEmpty()){
                addressVolumeOutStore!!.put(address, volumeOut.toString())
            } else {
                val updatedVolumeOut = initialVolumeOut.toBigInteger() + volumeOut.toBigInteger()
                addressVolumeOutStore!!.put(address, updatedVolumeOut.toString())
                addressVolumeOut!!.put(address, updatedVolumeOut.toString())
            }
        }
    }
}
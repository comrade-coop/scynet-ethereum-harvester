package harvester.common.processor

import harvester.common.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger

abstract class BlockFeatureAmountProcessor(private val FEATURE: String) : Processor<String, Messages.Block> {

    private var context: ProcessorContext? = null
    private var synchronizationStore: KeyValueStore<String, String>? = null

    override fun process(blockNumber: String, block: Messages.Block) {
        try {
            process(block)
        } catch (e: Exception) {
            // TODO use logger for this
            println("Exception occurred: $e while processing block: $blockNumber")
        }
    }

    protected abstract fun getFeatureValue(block: Messages.Block): String

    private fun process(block: Messages.Block) {
        val blockNumber = block.number
        val updatedAmount = updateAmount(getFeatureValue(block))

        println("Processing block with number: $blockNumber with updated $FEATURE amount: $updatedAmount")

        context!!.forward(blockNumber, updatedAmount)
        context!!.commit()
    }

    private fun updateAmount(featureValue: String): String {
        val amount = synchronizationStore!!.get(FEATURE)
        if (amount != null) {
            val updatedAmount = FeatureCalculator.sum(featureValue, amount)
            synchronizationStore!!.put(FEATURE, updatedAmount)
            return updatedAmount
        }
        synchronizationStore!!.put(FEATURE, BigInteger(featureValue).toString())
        return featureValue
    }

    override fun init(context: ProcessorContext?) {
        this.context = context
        synchronizationStore = context!!.getStateStore("SynchronizationStore") as KeyValueStore<String, String>
    }

    override fun close() {}
}

package harvester.common.processor

import harvester.common.messages.AddressFeature
import harvester.common.messages.Messages
import harvester.common.messages.Messages.Block
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger

abstract class TickFeatureProcessor(private val TICK_TIME_SECONDS: String?) : Processor<String, Block> {

    protected val ONE: Int = 1
    protected val NEGATIVE_ONE: Int = -1

    protected var context: ProcessorContext? = null
    private var synchronizationStore: KeyValueStore<String, String>? = null

    private var endOfTick: BigInteger? = null
    protected var firstBlockNumber: Int? = null
    private var lastProcessedBlockNumber: Int? = null

    protected var currentBlockNumber: Int? = null

    override fun process(blockNumber: String, block: Block) {
        try {
            process(block)
        } catch (e: Exception) {
            // TODO use logger for this
            println("Exception occurred: $e while processing block: $blockNumber")
        }
    }

    override fun init(context: ProcessorContext) {
        this.context = context

        initStores()
        synchronizationStore = context.getStateStore("SynchronizationStore") as KeyValueStore<String, String>

        val firstBlockNumberString = synchronizationStore!!.get("firstBlockNumber")
        firstBlockNumber = if (firstBlockNumberString.isNullOrEmpty()) NEGATIVE_ONE else firstBlockNumberString.toInt()

        val endOfTickString = synchronizationStore!!.get("endOfTick")
        endOfTick = if (endOfTickString.isNullOrEmpty()) BigInteger.valueOf(NEGATIVE_ONE.toLong()) else endOfTickString.toBigInteger()

        val lastProcessedBlockNumberString = synchronizationStore!!.get("lastProcessedBlockNumber")
        lastProcessedBlockNumber = if (lastProcessedBlockNumberString.isNullOrEmpty()) NEGATIVE_ONE else lastProcessedBlockNumberString.toInt()
    }

    override fun close() {
    }

    private fun process(block: Block) {
        val blockNumber = block.number.toInt()
        if (isProcessed(blockNumber)) {
            return
        }
        println(blockNumber)
        if (notSetEndOfTick()) {
            setEndOfTick(block.timestamp.toBigInteger())
            setFirstBlockNumber(blockNumber)
        }
        addFeatureBuilderWithTimestampForBlock(block)

        if (notInTick(block.timestamp.toBigInteger())) {
            commitFeature()
            slideTickForward(block.timestamp.toBigInteger())
        }
        extract(block)
        setLastProcessedBlock(blockNumber.toString())
    }

    private fun getTickTimeSeconds(): BigInteger {
        if (TICK_TIME_SECONDS != null) {
            return TICK_TIME_SECONDS.toBigInteger()
        }
        val tickTimeSeconds = System.getenv("TICK_TIME_SECONDS")
        if (tickTimeSeconds != null) {
            return tickTimeSeconds.toBigInteger()
        }
        return BigInteger.valueOf(3600)
    }

    private fun isProcessed(blockNumber: Int): Boolean {
        if (blockNumber <= lastProcessedBlockNumber!!) {
            return true
        }
        return false
    }

    private fun notSetEndOfTick(): Boolean {
        if (endOfTick == BigInteger.valueOf(NEGATIVE_ONE.toLong()))
            return true
        return false
    }

    protected fun setEndOfTick(timestamp: BigInteger) {
        endOfTick = timestamp + getTickTimeSeconds()
        synchronizationStore!!.put("endOfTick", endOfTick.toString())
    }

    protected fun setFirstBlockNumber(blockNumber: Int) {
        firstBlockNumber = blockNumber
        synchronizationStore!!.put("firstBlockNumber", firstBlockNumber.toString())
    }

    protected fun notInTick(timestamp: BigInteger): Boolean {
        if (timestamp > endOfTick)
            return true
        return false
    }

    private fun commitFeature() {
        val featureMap = buildFeatureMap()
        context!!.forward(endOfTick.toString(), featureMap)
        context!!.commit()
    }

    private fun setLastProcessedBlock(blockNumber: String) {
        synchronizationStore!!.put("lastProcessedBlockNumber", blockNumber)
    }

    protected abstract fun slideTickForward(timestamp: BigInteger)

    protected abstract fun buildFeatureMap(): AddressFeature.AddressFeatureMap

    protected abstract fun extract(block: Block)

    protected abstract fun initStores()

    protected abstract fun addFeatureBuilderWithTimestampForBlock(block: Messages.Block)
}



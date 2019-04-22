package harvester.common.processor

import harvester.common.messages.AddressFeature
import harvester.common.messages.Messages
import harvester.common.messages.Messages.Block
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger
import kotlin.system.measureTimeMillis

abstract class TickFeatureProcessor(private val TICK_TIME_SECONDS: String?) : Processor<String, Block> {
    protected val ONE: Int = 1
    protected val NEGATIVE_ONE: Int = -1
    private val batchSize = 500
    private var synchronizationStore: KeyValueStore<String, String>? = null
    private var lastProcessedBlockNumber: Int? = null
    private var endOfTick: BigInteger? = null
    private var totalTime: Long = 0L
    private var totalRealTme: Long = 0
    private var processedBlocks: Int = 0
    private var batchNumber: Int = 1
    private var batchTime: Long = 0
    private var startOfBatchRealTime: Long = System.currentTimeMillis()
    protected var context: ProcessorContext? = null
    protected var firstBlockNumber: Int? = null
    protected var currentBlockNumber: Int? = null

    override fun process(blockNumber: String, block: Block) {
        val time = measureTimeMillis {
            process(block)
        }
        println("Time -> $time for block #$blockNumber" )
        totalTime += time
        batchTime += time
        processedBlocks++
        if(processedBlocks % batchSize == 0){
            println("Batch #${batchNumber} processed in  ${batchTime}. Average processing time is ${totalTime/batchNumber}. Real batch time is ${getRealBatchTime()}. Average real time batch -> ${totalRealTme / batchNumber}")
            batchTime = 0
            batchNumber++

        }
    }

    private fun getRealBatchTime(): Long {
        val realBatchTime =  System.currentTimeMillis() - startOfBatchRealTime
        startOfBatchRealTime = System.currentTimeMillis()
        totalRealTme += realBatchTime
        return realBatchTime
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
        val timestamp = block.timestamp

        if (isProcessed(blockNumber)) {
            return
        }
        setEndOfTick(timestamp)
        addFeatureBuilderWithTimestampForBlock(block)
        if(firstBlockNumber == NEGATIVE_ONE){
            setFirstBlockNumber(blockNumber)
        }
        slideTickForward()
        extract(block)
        commitFeature(block.number)
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

    protected fun setEndOfTick(timestamp: String) {
        endOfTick = timestamp.toBigInteger()
        synchronizationStore!!.put("endOfTick", timestamp)
    }

    protected fun setFirstBlockNumber(blockNumber: Int) {
        firstBlockNumber = blockNumber
        synchronizationStore!!.put("firstBlockNumber", firstBlockNumber.toString())
    }

    protected fun notInTick(timestamp: BigInteger): Boolean {
        if (timestamp < endOfTick!! - getTickTimeSeconds())
            return true
        return false
    }

    private fun commitFeature(blockNumber: String) {
        val featureMap = buildFeatureMap()
        context!!.forward(blockNumber, featureMap)
        context!!.commit()
    }

    private fun setLastProcessedBlock(blockNumber: String) {
        synchronizationStore!!.put("lastProcessedBlockNumber", blockNumber)
    }

    protected abstract fun slideTickForward()

    protected abstract fun buildFeatureMap(): AddressFeature.AddressFeatureMap

    protected abstract fun extract(block: Block)

    protected abstract fun initStores()

    protected abstract fun addFeatureBuilderWithTimestampForBlock(block: Messages.Block)
}



package kafka.balanceLastSeen.distribution.processor

import harvester.common.messages.MatrixBlob
import harvester.common.messages.StreamJoin
import harvester.common.messages.StringList
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore
import java.math.BigInteger
import kotlin.math.roundToInt

class DistributionProcessor: Processor<String, StreamJoin.Join> {
    private var lastProcessedBlock: Int? = null

    private var addressPositionMap: HashMap<String, StringList.List> = HashMap()
    private var context: ProcessorContext? = null
    private var matrixStore: KeyValueStore<String, MatrixBlob.Blob>? = null
    private var addressPositionStore: KeyValueStore<String, StringList.List>? = null

    private val maxBalance = (Math.log10(10000000.0) / Math.log10(1.2)).roundToInt()
    private val maxLastSeen = (Math.log10(20736000.0) / Math.log10(1.2)).roundToInt()
    private val divideWeiToGetTenthOfEthereum = BigInteger.valueOf(100000000000000000)
    private val blocksInMonth: Int = 259200

    private var currentBlock: Int? = null

    private var currentTimestamp: String? = null

    private val matrix: MutableList<Float> = mutableListOf<Float>()

    override fun process(blockNumber: String?, features: StreamJoin.Join?) {


        var matrixInStore = matrixStore!!.get("matrix")
        if(matrixInStore == null){
            initMatrix()
            matrixInStore = matrixStore!!.get("matrix")
        }
        matrix.clear()
        matrix.addAll(matrixInStore.dataList)
        currentTimestamp = null
        currentBlock = blockNumber!!.toInt()
        val balances = features!!.featureMap1Map
        val lastSeen = features.featureMap2Map
        balances.forEach{ addressBalance ->
            val address = addressBalance.key
            val balance = addressBalance.value
            val timestamp = lastSeen.get(address)
            if(currentTimestamp.isNullOrEmpty()) currentTimestamp = timestamp!!
            val previousPosition = addressPositionStore!!.get(addressBalance.key)
            if( previousPosition != null){
                removeFromMatrix(calculateBlobDataPosition(previousPosition))
            }
            distribute(address, buildPosition(balance, timestamp!!, blockNumber))
        }

        updateLastSeenPositions()

        val distribution = MatrixBlob.Blob.newBuilder().addAllData(matrix).build()
        matrixStore!!.put("matrix", distribution)

        context!!.forward(blockNumber, distribution)
        context!!.commit()
        lastProcessedBlock = currentBlock!!
        println(blockNumber)
    }

    override fun init(context: ProcessorContext?){
        this.context  = context
        matrixStore = context!!.getStateStore("Matrix") as KeyValueStore<String, MatrixBlob.Blob>
        addressPositionStore = context.getStateStore("AddressPosition") as KeyValueStore<String, StringList.List>
    }

    override fun close() {
    }

    private fun removeFromMatrix(previousPosition: Int){
        val previousValue = matrix.get(previousPosition)
        matrix.set(previousPosition, previousValue - 1)
    }

    private fun distribute(address: String, position: StringList.List){
        val positionInBlobData = calculateBlobDataPosition(position)
        matrix[positionInBlobData]++
        addressPositionStore!!.put(address, position)
    }


    private fun weiToTenthOfEth(balance: String?): Long{
        return (balance!!.toBigInteger() / divideWeiToGetTenthOfEthereum).toLong()
    }

    private fun scaleDown(value: Double): Int{
        if(value < 1){
            return  0
        }
        return (Math.log10(value)/Math.log10(1.2)).roundToInt()
    }

    private fun updateLastSeenPositions(){
        val addressPositions = addressPositionStore!!.all()
        addressPositions.forEach { addressPosition ->
            if(isInCurrentBlock(addressPosition.value)) return@forEach
            removeFromMatrix(calculateBlobDataPosition(addressPosition.value))
            if (isOutdated(addressPosition.value)) {
                removeFromMatrix(calculateBlobDataPosition(addressPosition.value))
                addressPositionStore!!.delete(addressPosition.key)
                return@forEach
            }
            distribute(addressPosition.key, addressPosition.value)
        }
        addressPositions.close()
    }

    private fun isInCurrentBlock(position: StringList.List): Boolean{
        if(position.getItem(2) == currentBlock.toString()) return true
        return false
    }

    private fun isOutdated(position: StringList.List): Boolean{
        if(position.getItem(2).toInt() < currentBlock!!.minus(blocksInMonth)) return true
        return false
    }

    private fun calculateBlobDataPosition(position: StringList.List): Int{
        val balance = position.getItem(0)
        val timestamp = position.getItem(1)
        val weiBalance = weiToTenthOfEth(balance)
        val balanceGroup = Math.min(scaleDown(weiBalance.toDouble()), maxBalance - 1)
        val lastSeenGroup = Math.min(scaleDown((currentTimestamp!!.toBigInteger() - timestamp.toBigInteger()).toDouble()), maxLastSeen)
        if(lastSeenGroup == 0) return balanceGroup
        return (lastSeenGroup * maxLastSeen - 1) + balanceGroup
    }

    private fun buildPosition(balance:String, timestamp: String, blockNumber: String): StringList.List{
        return StringList.List.newBuilder()
                .addItem(balance)
                .addItem(timestamp)
                .addItem(blockNumber)
                .build()
    }

    private fun initMatrix(){
        val matrix: Array<Array<Long>> = Array(maxLastSeen) { Array(maxBalance) { 0L } }
        matrixStore!!.put("matrix",buildBlob(matrix))
    }

    private fun buildBlob(distributionMatrix: Array<Array<Long>>): MatrixBlob.Blob{
        val blobBuilder = MatrixBlob.Blob.newBuilder()
        val shape = MatrixBlob.Shape.newBuilder()
                .addDimension(maxBalance)
                .addDimension( maxLastSeen)
                .build()
        blobBuilder.setShape(shape)
        for (balanceGroup in 0..(maxBalance - 1)){
            for (lastSeenGroup in 0..(maxLastSeen - 1)){
                blobBuilder.addData(distributionMatrix[lastSeenGroup][balanceGroup].toFloat())
            }
        }
        return blobBuilder.build()
    }
}
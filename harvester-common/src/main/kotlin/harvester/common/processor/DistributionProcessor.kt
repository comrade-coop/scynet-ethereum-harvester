package harvester.common.processor

import harvester.common.messages.MatrixBlob
import org.apache.kafka.streams.processor.Processor
import harvester.common.messages.StreamJoin
import harvester.common.messages.StringList
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.state.KeyValueStore
import harvester.common.distribution.scaler.IScaler

abstract class DistributionProcessor(max0: Int, max1: Int, scaler0: IScaler, scaler1: IScaler): Processor<String, StreamJoin.Join> {

    private var lastProcessedBlock: Int? = null
    private val processed: HashSet<Int> = HashSet()
    private val processedAddresses: HashSet<String> = HashSet()
    private var context: ProcessorContext? = null
    private var matrixStore: KeyValueStore<String, MatrixBlob.Blob>? = null
    private val matrix: MutableList<Float> = mutableListOf<Float>()
    private var isInitializedMatrix: Boolean = false

    protected val max0: Int = max0
    protected val max1: Int = max1
    protected val scaler0: IScaler = scaler0
    protected val scaler1: IScaler = scaler1
    protected var addressPositionStore: KeyValueStore<String, StringList.List>? = null
    protected var currentBlock: Int? = null
    protected var currentTimestamp: Long? = null

    constructor(maxRows: Int, maxColumns: Int, scaler: IScaler): this(maxRows, maxColumns, scaler, scaler)

    override fun process(blockNumber: String?, features: StreamJoin.Join?) {
	if(!isInitializedMatrix){
		initMatrix()
		var matrixInStore = matrixStore!!.get("matrix")
		if(matrixInStore == null){
		    initMatrix()
		} else{
		    matrix.addAll(matrixInStore.dataList)
		}
	    isInitializedMatrix = true
	}
        currentBlock = blockNumber!!.toInt()
        currentTimestamp = System.currentTimeMillis() / 1000L
        if(processed(currentBlock!!)){
            return
        }
        if(notConsecutive(currentBlock!!)){
            return
        }

        val rowFeatures = features!!.featureMap1Map
        val columnFeatures = features.featureMap2Map

        iterate(rowFeatures, columnFeatures)

        //not always needed
        updatePositionsAfterDistributingCurrentAddresses()

        val distribution = MatrixBlob.Blob.newBuilder().addAllData(matrix).build()
        matrixStore!!.put("matrix", distribution)

        context!!.forward(blockNumber, distribution)
        context!!.commit()
        lastProcessedBlock = currentBlock!!
        processed.add(currentBlock!!)
        println(blockNumber)
    }

    override fun init(context: ProcessorContext?) {
        this.context  = context
        matrixStore = context!!.getStateStore("Matrix") as KeyValueStore<String, MatrixBlob.Blob>
        addressPositionStore = context.getStateStore("AddressPosition") as KeyValueStore<String, StringList.List>

       

    }

    override fun close() {
    }
	
    private fun initMatrix(){
        var matrixInStore = matrixStore!!.get("matrix")
        if(matrixInStore == null){
            initMatrixInStore()
        } else{
            matrix.addAll(matrixInStore.dataList)
        }
    }
    private fun processed(blockNumber: Int): Boolean{
        if (processed.contains(blockNumber)){
            return true
        }
        return false
    }

    private fun notConsecutive(blockNumber: Int): Boolean{
        if(lastProcessedBlock != null &&  lastProcessedBlock != blockNumber - 1 ){
            return true
        }
        return false
    }

    private fun initMatrixInStore(){
        val matrixBlob = initMatrixBlob()
        matrixStore!!.put("matrix", matrixBlob)
        this.matrix.addAll(matrixBlob.dataList)
    }

    private fun initMatrixBlob(): MatrixBlob.Blob{
        val blobBuilder = MatrixBlob.Blob.newBuilder()

        val shape = MatrixBlob.Shape.newBuilder()
                .addDimension(max0)
                .addDimension( max1)
                .build()

        blobBuilder.setShape(shape)
        for (index in 0..(max0 * max1 - 1)){

                blobBuilder.addData(0.toFloat())
        }
        return blobBuilder.build()
    }

    private fun iterate(features0: Map<String, String>, features1: Map<String, String>){
        leftJoinAndDistribute(features0, features1)
        rightJoinAndDistribute(features0, features1)
    }

    private fun leftJoinAndDistribute(features0: Map<String, String>, features1: Map<String, String>){
        features0.forEach{ f0 ->
            val address = f0.key
            if(processedAddresses.contains(address)) return@forEach
            val feature0 = f0.value
            val feature1 = features1.get(address)

            val previousPosition = addressPositionStore!!.get(address)
            if( previousPosition != null){
                removeFromMatrix(calculatePositionInBlobData(previousPosition))
            }
            if(feature1.isNullOrEmpty()){
                //TODO: log this
                distribute(address, buildPosition(feature0, "0", currentBlock.toString()))
            } else{
                distribute(address, buildPosition(feature0, feature1, currentBlock.toString()))
            }
            processedAddresses.add(address)
        }
    }

    private fun rightJoinAndDistribute(features0: Map<String, String>, features1: Map<String, String>){
        features1.forEach{ f1 ->
            val address = f1.key
            if(processedAddresses.contains(address)) return@forEach
            val feature1 = f1.value
            val feature0 = features0.get(address)

            val previousPosition = addressPositionStore!!.get(address)
            if( previousPosition != null){
                removeFromMatrix(calculatePositionInBlobData(previousPosition))
            }
            if(feature0.isNullOrEmpty()){
                //TODO: log this
                distribute(address, buildPosition("0", feature1, currentBlock.toString()))
            } else{
                distribute(address, buildPosition(feature0, feature1, currentBlock.toString()))
            }
            processedAddresses.add(address)
        }
    }

    private fun buildPosition(feature0:String, feature1: String, blockNumber: String): StringList.List{
        return StringList.List.newBuilder()
                .addItem(feature0)
                .addItem(feature1)
                .addItem(blockNumber)
                .build()
    }

    protected fun removeFromMatrix(previousPosition: Int){
        val previousValue = matrix.get(previousPosition)
        matrix.set(previousPosition, previousValue - 1)
    }

    protected fun calculatePositionInBlobData(position: StringList.List): Int{
        val feature0 = position.getItem(0)
        val feature1 = position.getItem(1)

        val group0 =  getGroup0(feature0)
        val group1 = getGroup1(feature1)
        if(group1 == 0) return group0
        return (group0 * max1) + group1 - 1
    }

    protected fun distribute(address: String, position: StringList.List){
        val positionInBlobData = calculatePositionInBlobData(position)
        matrix[positionInBlobData]++
        addressPositionStore!!.put(address, position)
    }

    protected abstract fun updatePositionsAfterDistributingCurrentAddresses()

    open fun getGroup0(feature0: String): Int{
        return Math.min(scaler0.scaleDown(feature0), max0 - 1)
    }

    open fun getGroup1(feature1: String): Int{
        return Math.min(scaler1.scaleDown(feature1), max1 - 1)
    }
}

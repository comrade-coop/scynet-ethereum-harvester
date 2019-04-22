package harvester.common.processor

import harvester.common.distribution.scaler.IScaler
import harvester.common.messages.MatrixBlob
import harvester.common.messages.StreamJoin
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import java.math.BigInteger

class AccountBalanceDistributionProcessor(private val scaler: IScaler, private val max: Double = 100000000000000000000000000.0): Processor<String, StreamJoin.Join> {
    private var context: ProcessorContext? = null
    private var currentBlock: Int? = null
    private val processed: HashSet<Int> = HashSet()
    private var lastProcessedBlock: Int? = null
    private val maxGroup: Int = scaler.scaleDown(max.toString())
    private var matrix: MutableList<Float>? = null

    private val shape: MatrixBlob.Shape = MatrixBlob.Shape.newBuilder()
            .addDimension(3)
            .addDimension(maxGroup)
            .build()


    override fun process(blockNumber: String?, featureMaps: StreamJoin.Join?) {
        matrix = MutableList(maxGroup * 3, {i -> 0F})
        currentBlock = blockNumber!!.toInt()
        if(processed(currentBlock!!)){
            return
        }
        if(notConsecutive(currentBlock!!)){
            return
        }

        val balances = featureMaps!!.featureMap1Map
        val features0  = featureMaps.featureMap2Map
        val features1 = featureMaps.featureMap3Map
        val features2 = featureMaps.featureMap4Map

        balances.forEach { address, balance ->
            val balanceGroup = Math.min(scaler.scaleDown(balance), maxGroup - 1)
            val feature0 = features0.getOrDefault(address, "")
            if(feature0 != ""){
                distribute(0, balanceGroup, feature0)
            }
            val feature1 = features1.getOrDefault(address, "")
            if(feature1 != ""){
                distribute(1, balanceGroup, feature1)
            }
            val feature2 = features2.getOrDefault(address, "")
            if(feature2 != ""){
                distribute(2, balanceGroup, feature2)
            }
        }
        scaleDownMatrix()
        val distribution = MatrixBlob.Blob.newBuilder()
                .setShape(shape)
                .addAllData(matrix)
                .build()

        context!!.forward(blockNumber, distribution)
        context!!.commit()
        lastProcessedBlock = currentBlock!!
        processed.add(currentBlock!!)
        println(blockNumber)
    }

    override fun init(context: ProcessorContext?) {
        this.context = context
        initMatrix()
    }

    override fun close() {
    }

    private fun initMatrix(){
        for (i in 0..(maxGroup * 3 - 1)){
            matrix?.add(0F)
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

    private fun distribute(row: Int, column: Int, value: String){
        if(row == 0){
            matrix!![column] += value.toFloat()
        }else{
            matrix!![(maxGroup * row) - 1 + column]+= value.toFloat()
        }
    }

    private fun scaleDownMatrix(){
        for (position in 0..(3 * maxGroup - 1)){
            val oldValue = matrix!![position]
            matrix!![position]  = scaler.scaleDown(oldValue.toString()).toFloat()
        }
    }
}
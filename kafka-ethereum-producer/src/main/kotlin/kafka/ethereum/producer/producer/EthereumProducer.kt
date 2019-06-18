package kafka.ethereum.producer.producer

import harvester.common.messages.Messages
import kafka.ethereum.producer.messages.EthereumMessageBuilder
import kotlinx.coroutines.*
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.protocol.parity.Parity
import java.io.File
import java.math.BigInteger
import kotlin.system.measureTimeMillis
import org.web3j.protocol.parity.methods.response.Trace as ParityTrace

class EthereumProducer(
    private val producer: KafkaProducer<String, Messages.Block>,
    private val parityService: Parity,
    private val ethereumMessageBuilder: EthereumMessageBuilder
) {
    private val blocks: HashMap<BigInteger,Deferred< Messages.Block>> = HashMap()
    private var elapsedTimeMS: Long = 0
    private var processedBatches: Long = 1
    private val file: File = File("lastProducedBlock.txt")

    fun start() = runBlocking {
        var firstBlockNumber = BigInteger.ONE //getLastProducedBlock() + BigInteger.ONE
        val numberOfBlocks = 500
        try {
            while(true){
                val time = measureTimeMillis {
                    val one = async { loadBlocks(firstBlockNumber, numberOfBlocks)}
                    val two = async { produceBlocks(firstBlockNumber, numberOfBlocks) }
                    one.await()
                    two.await()
                }
                println("finished batch #$processedBatches in $time")
                println("Average time for batch  of size $numberOfBlocks ->  ${getAvgTime(time)}")
                firstBlockNumber += numberOfBlocks.toBigInteger()
                processedBatches++
            }
        } catch (e: Exception) {
            println(e)
            System.err.println(e.toString() + ":" + e.cause)
        } finally {
            producer.flush()
        }

    }

    private fun getAvgTime(time: Long): Long{
        elapsedTimeMS += time
        return elapsedTimeMS/processedBatches
    }

    private fun getLastProducedBlock(): BigInteger{
        val lastProducedBlock = file.readText()
        if (lastProducedBlock.isNullOrEmpty()){
            return BigInteger.ZERO
        } else{
            return lastProducedBlock.toBigInteger()
        }
    }

    private suspend fun CoroutineScope.produceBlocks(firstBlockNumber: BigInteger, numberOfBlocks: Int){
        var i = 0
        while(i <= numberOfBlocks){
            val blockNumber = firstBlockNumber + i.toBigInteger()
            val block = blocks.get(blockNumber)
            if( block == null){
                delay(50L)
            } else{
                val readyBlock = block.await()
                val acknowledged =
                    producer.send(ProducerRecord("ethereum_blocks", null, readyBlock.number, readyBlock))
                acknowledged.get()
                blocks.remove(blockNumber)
                file.writeText(readyBlock.number)
                println("Block #${readyBlock.number} with size ${readyBlock.serializedSize} successfully sent!")
                i++
            }
        }
    }

    private fun CoroutineScope.loadBlock(blockNumber: BigInteger){
        val ethBlock = parityService.ethGetBlockByNumber(DefaultBlockParameter.valueOf(blockNumber), true).sendAsync().get().block
        if (ethBlock == null){
            println()
            return
        }
        val futureBlock = async {
            return@async ethereumMessageBuilder.buildBlock(ethBlock)
        }
        blocks.put(ethBlock.number, futureBlock)
        println("Job for block #${ethBlock.number} done!")
    }
    private  fun CoroutineScope.loadBlocks(firstBlockNumber: BigInteger, numberOfBlocks: Int )  {
        var blockNumber = firstBlockNumber
        for(i in 0..numberOfBlocks) {
            async { loadBlock(blockNumber + i.toBigInteger()) }
        }
    }
}

package kafka.ethereum.producer.producer

import kafka.ethereum.producer.messages.EthereumMessageBuilder
import kafka.ethereum.producer.messages.Messages.Block
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.protocol.parity.Parity
import java.math.BigInteger
import org.web3j.protocol.parity.methods.response.Trace as ParityTrace

class EthereumProducer(
    private val producer: KafkaProducer<String, Block>,
    private val parityService: Parity,
    private val ethereumMessageBuilder: EthereumMessageBuilder
) {

    fun start() {
        val firstBlockNumber = BigInteger.valueOf(100000L)
        try {
            subscribeToBlockFlowable(firstBlockNumber)
        } catch (e: Exception) {
            println(e)
        } finally {
            producer.flush()
        }
    }

    private fun subscribeToBlockFlowable(firstBlockNumber: BigInteger) {
        parityService
            .replayPastAndFutureBlocksFlowable(DefaultBlockParameter.valueOf(firstBlockNumber), true)
            .subscribe {
                val ethBlock = it.block
                try {
                    val block = ethereumMessageBuilder.buildBlock(ethBlock)
                    println(block.number)
                    val acknowledged = producer.send(ProducerRecord("ethereum_blocks", block.number, block))
                    acknowledged.get()
                } catch (e: Exception) {
                    System.err.println(e.toString() + ":" + e.cause)
                }
            }
    }

}





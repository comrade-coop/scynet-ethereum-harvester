package kafka.blockchain.producer.producer

import kafka.blockchain.producer.messages.BlockchainMessageBuilder
import kafka.blockchain.producer.messages.Messages.Block
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.protocol.parity.Parity
import java.math.BigInteger
import org.web3j.protocol.parity.methods.response.Trace as ParityTrace

class BlockchainProducer(
    private val producer: KafkaProducer<String, Block>,
    private val parityService: Parity,
    private val blockchainMessageBuilder: BlockchainMessageBuilder
) {

    fun start() {
        val firstBlockNumber = BigInteger.valueOf(1000L)
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
                val block = blockchainMessageBuilder.buildBlock(ethBlock)
                val acks = producer.send(ProducerRecord("ethereum_blocks", block.number, block))
                acks.get()
            }
    }

}





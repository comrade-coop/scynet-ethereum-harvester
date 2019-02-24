package kafka.blockchain.producer

import kafka.blockchain.producer.messages.BlockchainMessageBuilder
import kafka.blockchain.producer.parity.ParityWebSocketsService
import kafka.blockchain.producer.producer.BlockchainProducer
import kafka.blockchain.producer.producer.CustomKafkaProducer

fun main(args: Array<String>) {

    val producer = CustomKafkaProducer().create("127.0.0.1:9092")
    val parityService = ParityWebSocketsService().startParity()
    val blockchainMessageBuilder = BlockchainMessageBuilder()

    val blockchainProducer = BlockchainProducer(producer, parityService, blockchainMessageBuilder)
    blockchainProducer.start()
}


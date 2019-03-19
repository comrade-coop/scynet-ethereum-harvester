package kafka.ethereum.producer

import kafka.ethereum.producer.messages.EthereumMessageBuilder
import kafka.ethereum.producer.parity.ParityWebSocketsService
import kafka.ethereum.producer.producer.EthereumProducer
import kafka.ethereum.producer.producer.CustomKafkaProducer

fun main(args: Array<String>) {
    val producer = CustomKafkaProducer().create("127.0.0.1:29092")
    val parityService = ParityWebSocketsService().startParity()
    val ethereumMessageBuilder = EthereumMessageBuilder()
    val ethereumProducer =
        EthereumProducer(producer, parityService, ethereumMessageBuilder)
    ethereumProducer.start()
}


package kafka.balance.producer

import kafka.balance.producer.balance.BalanceCalculator
import kafka.balance.producer.consumer.BalanceConsumer
import kafka.balance.producer.producer.BalanceProducer
import kafka.balance.producer.producer.CustomKafkaProducer

fun main(args: Array<String>) {

    val broker = "127.0.0.1:29092"
    val producer = CustomKafkaProducer().create(broker)
    val balanceCalculator = BalanceCalculator()
    val balanceConsumer = BalanceConsumer().createConsumer(broker)

    val balanceProducer = BalanceProducer(producer, balanceConsumer, balanceCalculator)
    balanceProducer.start()
}


package kafka.balance.producer.consumer

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import java.time.Duration
import java.util.*
import kafka.balance.producer.messages.Messages.Block
import kafka.balance.producer.serialization.BlockDeserializer

class BalanceConsumer() {

    fun createConsumer(broker: String): KafkaConsumer<String, Block> {
        val properties = Properties()
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, broker)
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "balance_consumer")
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer().javaClass.name)
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, BlockDeserializer().javaClass.name)
        return KafkaConsumer(properties)
    }

}
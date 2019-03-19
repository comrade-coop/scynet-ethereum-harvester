package kafka.ethereum.producer.producer

import kafka.ethereum.producer.messages.Messages
import kafka.ethereum.producer.serialization.BlockSerializer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*

class CustomKafkaProducer() {

    fun create(broker: String): KafkaProducer<String, Messages.Block> {
        val properties = Properties()
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, broker)
        properties.setProperty(ProducerConfig.ACKS_CONFIG, "1")
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer().javaClass.name)
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, BlockSerializer().javaClass.name)
        properties.setProperty("log.retention.hours", Int.MAX_VALUE.toString())
        return KafkaProducer(properties)
    }

}
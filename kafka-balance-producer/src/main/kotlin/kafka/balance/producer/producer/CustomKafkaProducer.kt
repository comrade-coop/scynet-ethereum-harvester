package kafka.balance.producer.producer

import kafka.balance.producer.messages.Messages
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*

internal class CustomKafkaProducer() {

    fun create(broker: String): KafkaProducer<String, String> {
        val properties = Properties()
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, broker)
        properties.setProperty(ProducerConfig.ACKS_CONFIG, "1")
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer().javaClass.name)
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer().javaClass.name)
        return KafkaProducer(properties)
    }

}
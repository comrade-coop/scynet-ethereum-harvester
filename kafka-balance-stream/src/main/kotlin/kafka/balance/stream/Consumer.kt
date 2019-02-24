package kafka.balance.stream

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*

fun main(){
    val consumer = Consumer().create()
    consumer.subscribe(listOf("balance"))

    while(true){
        val consumerRecords = consumer.poll(1000)

        consumerRecords.forEach { record ->
            println(record.key())
            println(record.value())
        }
    }

}

class Consumer{
    fun create(): KafkaConsumer<String, String> {
        val properties = Properties()
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092")
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "consumer")
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer().javaClass.name)
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer().javaClass.name)
        return KafkaConsumer(properties)
    }
}
package kafka.balance.producer.producer

import kafka.balance.producer.balance.BalanceCalculator
import kafka.balance.producer.messages.Messages
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import java.time.Duration

class BalanceProducer(
    private val producer: KafkaProducer<String, String>,
    private val balanceConsumer: KafkaConsumer<String, Messages.Block>,
    private val balanceCalculator: BalanceCalculator
) {

    private val ETHEREUM_BALANCES_TOPIC = "ethereum_balances"

    fun start() {
        balanceConsumer.subscribe(listOf("ethereum_blocks"))
        while (true) {
            val records = balanceConsumer.poll(Duration.ofSeconds(1L))
            records.forEach { record ->
                val block = record.value()
                try {
                    val accountBalances = balanceCalculator.calculateAccountBalances(block)
                    accountBalances.forEach { accountBalance ->
                        println("account: " + accountBalance.key)
                        println("balance:" + accountBalance.value)
                        send(accountBalance.key, accountBalance.value.toString())
                    }
                } catch (e: Exception) {

                }
            }
        }
    }

    private fun sendAccountBalances() {

    }

    private fun send(account: String, balance: String) {
        val acknowledged = producer.send(ProducerRecord(ETHEREUM_BALANCES_TOPIC, account, balance))
        acknowledged.get()
    }

}





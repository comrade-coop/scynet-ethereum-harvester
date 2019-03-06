package kafka.balance.stream.serialization

import org.apache.kafka.common.serialization.Serializer
import kafka.balance.stream.messages.AddressBalance

class AddressBalanceMapSerializer : Serializer<AddressBalance.AddressBalanceMap> {

    override fun serialize(topic: String?, data: AddressBalance.AddressBalanceMap): ByteArray {
        return data.toByteArray()
    }

    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun close() {
    }

}
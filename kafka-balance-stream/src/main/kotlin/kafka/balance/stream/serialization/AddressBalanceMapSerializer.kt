package kafka.balance.stream.serialization

import org.apache.kafka.common.serialization.Serializer


class AddressBalanceMapSerializer : Serializer<AddressBalance.AddressBalanceMap> {

    override fun serialize(topic: String?, data: AddressBalance.AddressBalanceMap): ByteArray {
        return data.toByteArray()
    }

    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun close() {
    }

}
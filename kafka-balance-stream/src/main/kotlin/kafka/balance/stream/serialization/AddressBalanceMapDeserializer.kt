package kafka.balance.stream.serialization

import org.apache.kafka.common.serialization.Deserializer;

class AddressBalanceMapDeserializer : Deserializer<AddressBalance.AddressBalanceMap> {

    override fun deserialize(topic: String?, data: ByteArray?): AddressBalance.AddressBalanceMap {
        return AddressBalance.AddressBalanceMap.parseFrom(data)
    }

    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun close() {
    }
}
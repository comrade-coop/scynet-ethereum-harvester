package kafka.balance.stream.serialization

import org.apache.kafka.common.serialization.Deserializer
import kafka.balance.stream.messages.AddressFeature

class AddressFeatureMapDeserializer : Deserializer<AddressFeature.AddressFeatureMap> {

    override fun deserialize(topic: String?, data: ByteArray?): AddressFeature.AddressFeatureMap {
        return AddressFeature.AddressFeatureMap.parseFrom(data)
    }

    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun close() {
    }
}
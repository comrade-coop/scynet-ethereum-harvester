package kafka.balance.stream.serialization

import org.apache.kafka.common.serialization.Serializer
import kafka.balance.stream.messages.AddressFeature

class AddressFeatureMapSerializer : Serializer<AddressFeature.AddressFeatureMap> {

    override fun serialize(topic: String?, data: AddressFeature.AddressFeatureMap): ByteArray {
        return data.toByteArray()
    }

    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun close() {
    }

}
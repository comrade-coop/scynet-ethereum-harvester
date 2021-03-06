package harvester.common.serialization

import harvester.common.messages.AddressFeature
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.serialization.Serializer

class AddressFeatureSerdes: Serde<AddressFeature.AddressFeatureMap> {

    private val addressFeatureMapSerializer = AddressFeatureMapSerializer()
    private val addressFeatureMapDeserializer = AddressFeatureMapDeserializer()

    override fun configure(map: Map<String, *>, b: Boolean) {


    }

    override fun close() {
        addressFeatureMapSerializer.close()
        addressFeatureMapDeserializer.close()

    }

    override fun serializer(): Serializer<AddressFeature.AddressFeatureMap> {
        return addressFeatureMapSerializer
    }

    override fun deserializer(): Deserializer<AddressFeature.AddressFeatureMap>? {
        return addressFeatureMapDeserializer
    }
}
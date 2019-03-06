package kafka.lastSeen.stream.serialization

import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.serialization.Serializer
import kafka.lastSeen.stream.messages.AddressLastSeen


class AddressLastSeenSerdes: Serde<AddressLastSeen.AddressLastSeenMap> {

    private val addressLastSeenMapSerializer = AddressLastSeenMapSerializer()
    private val addressLastSeenMapDeserializer = AddressLastSeenMapDeserializer()

    override fun configure(map: Map<String, *>, b: Boolean) {


    }

    override fun close() {
        addressLastSeenMapSerializer.close()
        addressLastSeenMapDeserializer.close()

    }

    override fun serializer(): Serializer<AddressLastSeen.AddressLastSeenMap> {
        return addressLastSeenMapSerializer
    }

    override fun deserializer(): Deserializer<AddressLastSeen.AddressLastSeenMap>? {
        return addressLastSeenMapDeserializer
    }
}
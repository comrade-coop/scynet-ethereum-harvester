package kafka.lastSeen.stream.serialization

import org.apache.kafka.common.serialization.Serializer
import kafka.lastSeen.stream.messages.AddressLastSeen

class AddressLastSeenMapSerializer : Serializer<AddressLastSeen.AddressLastSeenMap> {

    override fun serialize(topic: String?, data: AddressLastSeen.AddressLastSeenMap): ByteArray {
        return data.toByteArray()
    }

    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun close() {
    }

}
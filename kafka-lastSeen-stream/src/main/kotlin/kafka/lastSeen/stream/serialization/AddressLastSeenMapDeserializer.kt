package kafka.lastSeen.stream.serialization

import org.apache.kafka.common.serialization.Deserializer;
import kafka.lastSeen.stream.messages.AddressLastSeen

class AddressLastSeenMapDeserializer : Deserializer<AddressLastSeen.AddressLastSeenMap> {

    override fun deserialize(topic: String?, data: ByteArray?): AddressLastSeen.AddressLastSeenMap {
        return AddressLastSeen.AddressLastSeenMap.parseFrom(data)
    }

    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun close() {
    }
}
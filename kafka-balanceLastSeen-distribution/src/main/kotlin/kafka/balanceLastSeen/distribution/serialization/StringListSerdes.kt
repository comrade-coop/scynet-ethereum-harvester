package kafka.balanceLastSeen.distribution.serialization

import kafka.balanceLastSeen.distribution.messages.StringList
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.serialization.Serializer

class StringListSerdes: Serde<StringList.List> {

    private val serializer = StringListSerializer()
    private val deserializer = StringListDeserializer()
    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun deserializer(): Deserializer<StringList.List> {
        return deserializer
    }

    override fun close() {
        serializer.close()
        deserializer.close()
    }

    override fun serializer(): Serializer<StringList.List> {
        return serializer
    }
}
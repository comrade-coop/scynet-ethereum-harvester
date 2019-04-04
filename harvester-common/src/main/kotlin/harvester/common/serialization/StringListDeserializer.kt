package harvester.common.serialization

import kafka.balanceLastSeen.distribution.messages.StringList
import org.apache.kafka.common.serialization.Deserializer

class StringListDeserializer: Deserializer<StringList.List> {
    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun deserialize(topic: String?, data: ByteArray?): StringList.List {
        return StringList.List.parseFrom(data!!)
    }

    override fun close() {
    }
}
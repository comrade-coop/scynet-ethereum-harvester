package kafka.balanceLastSeen.distribution.serialization

import kafka.balanceLastSeen.distribution.messages.StringList
import org.apache.kafka.common.serialization.Serializer

class StringListSerializer: Serializer<StringList.List> {
    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun serialize(topic: String?, data: StringList.List?): ByteArray {
        return data!!.toByteArray()
    }

    override fun close() {
    }
}
package harvester.common.serialization

import harvester.common.messages.StreamJoin
import org.apache.kafka.common.serialization.Serializer

class JoinSerializer: Serializer<StreamJoin.Join> {
    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun serialize(topic: String?, data: StreamJoin.Join?): ByteArray {
       return data!!.toByteArray()
    }

    override fun close() {
    }
}
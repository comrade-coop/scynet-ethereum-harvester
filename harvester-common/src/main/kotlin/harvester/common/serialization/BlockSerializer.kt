package harvester.common.serialization

import harvester.common.messages.Messages
import org.apache.kafka.common.serialization.Serializer

class BlockSerializer : Serializer<Messages.Block> {

    override fun serialize(topic: String?, data: Messages.Block): ByteArray {
        return data.toByteArray()
    }

    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun close() {
    }

}
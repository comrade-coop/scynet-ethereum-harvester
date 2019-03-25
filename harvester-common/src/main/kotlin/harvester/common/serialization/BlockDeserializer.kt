package harvester.common.serialization

import harvester.common.messages.Messages
import org.apache.kafka.common.serialization.Deserializer

class BlockDeserializer : Deserializer<Messages.Block> {

    override fun deserialize(topic: String?, data: ByteArray?): Messages.Block {
        return Messages.Block.parseFrom(data)
    }

    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun close() {
    }
}
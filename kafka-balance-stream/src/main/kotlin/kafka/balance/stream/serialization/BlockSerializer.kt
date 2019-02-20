package kafka.balance.stream.serialization

import org.apache.kafka.common.serialization.Serializer
import kafka.balance.stream.messages.Messages.Block

class BlockSerializer : Serializer<Block> {

    override fun serialize(topic: String?, data: Block): ByteArray {
        return data.toByteArray()
    }

    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun close() {
    }

}
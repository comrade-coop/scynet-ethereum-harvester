package kafka.transferLogsNumber.stream.serialization

import kafka.transferLogsNumber.stream.messages.Messages.Block
import org.apache.kafka.common.serialization.Deserializer

class BlockDeserializer : Deserializer<Block> {

    override fun deserialize(topic: String?, data: ByteArray?): Block {
        return Block.parseFrom(data)
    }

    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun close() {
    }
}
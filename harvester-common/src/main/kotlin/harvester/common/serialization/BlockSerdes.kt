package harvester.common.serialization

import harvester.common.messages.Messages
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.serialization.Serializer

class BlockSerdes : Serde<Messages.Block> {

    private val blockSerializer = BlockSerializer()
    private val blockDeserializer = BlockDeserializer()

    override fun configure(map: Map<String, *>, b: Boolean) {
    }

    override fun close() {
        blockSerializer.close()
        blockDeserializer.close()
    }

    override fun serializer(): Serializer<Messages.Block> {
        return blockSerializer
    }

    override fun deserializer(): Deserializer<Messages.Block>? {
        return blockDeserializer
    }
}
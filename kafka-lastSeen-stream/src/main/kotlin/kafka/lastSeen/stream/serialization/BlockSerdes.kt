package kafka.lastSeen.stream.serialization

import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serde
import kafka.lastSeen.stream.messages.Messages.Block
import org.apache.kafka.common.serialization.Serializer



class BlockSerdes: Serde<Block> {

    private val blockSerializer = BlockSerializer()
    private val blockDeserializer = BlockDeserializer()

    override fun configure(map: Map<String, *>, b: Boolean) {


    }

    override fun close() {
        blockSerializer.close()
        blockDeserializer.close()

    }

    override fun serializer(): Serializer<Block> {
        return blockSerializer
    }

    override fun deserializer(): Deserializer<Block>? {
        return blockDeserializer
    }
}
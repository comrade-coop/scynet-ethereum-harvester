package harvester.common.serialization

import harvester.common.messages.MatrixBlob
import org.apache.kafka.common.serialization.Deserializer

class BlobDeserializer: Deserializer<MatrixBlob.Blob> {
    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun deserialize(topic: String?, data: ByteArray?): MatrixBlob.Blob {
        return MatrixBlob.Blob.parseFrom(data)
    }

    override fun close() {
    }
}
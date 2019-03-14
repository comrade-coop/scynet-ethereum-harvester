package kafka.balanceLastSeen.distribution.serialization

import kafka.balanceLastSeen.distribution.messages.MatrixBlob
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
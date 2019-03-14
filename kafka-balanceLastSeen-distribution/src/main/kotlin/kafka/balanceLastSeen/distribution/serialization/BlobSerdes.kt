package kafka.balanceLastSeen.distribution.serialization

import kafka.balanceLastSeen.distribution.messages.MatrixBlob
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.serialization.Serializer

class BlobSerdes: Serde<MatrixBlob. Blob> {

    private val blobSerializer = BlobSerializer()
    private val blobDeserializr = BlobDeserializer()

    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun deserializer(): Deserializer<MatrixBlob.Blob> {
        return blobDeserializr
    }

    override fun close() {
        blobSerializer.close()
        blobDeserializr.close()
    }

    override fun serializer(): Serializer<MatrixBlob.Blob> {
        return blobSerializer
    }
}
package harvester.common.serialization

import kafka.balanceLastSeen.distribution.messages.MatrixBlob
import org.apache.kafka.common.serialization.Serializer

class BlobSerializer: Serializer<MatrixBlob.Blob> {
    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {
    }

    override fun serialize(topic: String?, data: MatrixBlob.Blob): ByteArray {
        return data.toByteArray()
    }

    override fun close() {
    }
}
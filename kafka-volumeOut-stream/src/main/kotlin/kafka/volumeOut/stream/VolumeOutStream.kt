package kafka.volumeOut.stream

import harvester.common.feature.FeatureStream
import harvester.common.topics.Topics
import kafka.volumeOut.stream.processor.VolumeOutProcessor

fun main() {
    val volumeOutStream = FeatureStream(Topics.VOLUME_OUT, VolumeOutProcessor())
    volumeOutStream.start()
}

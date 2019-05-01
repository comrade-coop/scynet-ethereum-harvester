package kafka.volumeIn.stream

import harvester.common.feature.FeatureStream
import harvester.common.topics.Topics
import kafka.volumeIn.stream.processor.VolumeInProcessor

fun main(args: Array<String>) {
    val volumeInStream = FeatureStream(Topics.VOLUME_IN, VolumeInProcessor())
    volumeInStream.start()
}


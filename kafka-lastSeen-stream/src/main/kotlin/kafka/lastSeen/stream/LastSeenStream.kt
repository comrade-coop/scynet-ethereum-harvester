package kafka.lastSeen.stream

import harvester.common.feature.FeatureStream
import harvester.common.topics.Topics
import kafka.lastSeen.stream.processor.LastSeenProcessor

fun main(args: Array<String>) {
    val lastSeenStream = FeatureStream(Topics.LAST_SEEN, LastSeenProcessor())
    lastSeenStream.start()
}

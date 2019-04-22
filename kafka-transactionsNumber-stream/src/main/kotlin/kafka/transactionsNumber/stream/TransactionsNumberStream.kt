package kafka.transactionsNumber.stream

import harvester.common.config.AddressFeatureStreamConfig
import harvester.common.feature.FeatureStream
import harvester.common.serialization.BlockDeserializer
import harvester.common.topics.Topics
import kafka.transactionsNumber.stream.processor.TransactionsNumberProcessor
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.Topology

fun main(args: Array<String>) {
    val transactionsNumberStream = FeatureStream(Topics.TRANSACTIONS_N, TransactionsNumberProcessor())
    transactionsNumberStream.start()
}


package kafka.balance.stream

import harvester.common.feature.FeatureStream
import harvester.common.topics.Topics
import kafka.balance.stream.processor.AddressBalanceProcessor

fun main(args: Array<String>) {
    val balanceStream = FeatureStream(Topics.BALANCE, AddressBalanceProcessor())
    balanceStream.start()
}

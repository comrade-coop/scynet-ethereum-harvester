package kafka.balanceLastSeen.distribution

import harvester.common.distribution.AccountNumberDistribution
import harvester.common.distribution.scaler.BalanceScaler
import harvester.common.distribution.scaler.LogOnePointTwoScaler
import harvester.common.topics.Topics
import kafka.balanceLastSeen.distribution.processor.BalanceLastSeenDistributionProcessor


fun main(args: Array<String>) {
    AccountNumberDistribution(
            Topics.BALANCE,
            Topics.LAST_SEEN,
            BalanceLastSeenDistributionProcessor(BalanceScaler(LogOnePointTwoScaler()), LogOnePointTwoScaler()))
            .start()
}
package harvester.entrypoint

import io.grpc.ServerBuilder
import io.grpc.ManagedChannelBuilder
import Scynet.Shared.Agent
import Scynet.Shared.Shape
import kafka.balanceLastSeen.distribution.processor.BalanceLastSeenDistributionProcessor

fun main(args: Array<String>) {
    val port = 9980
    val hatcheryChannel = ManagedChannelBuilder.forAddress("127.0.0.1", 9998).usePlaintext().build()
    val balanceLastSeenDistributionUUID = "769d5eb3-0ada-4ae5-8e1b-4fa6600ddae0"
    val componentService = ComponentService(hatcheryChannel, "127.0.0.1:$port", listOf(
        Agent.newBuilder()
            .setUuid(balanceLastSeenDistributionUUID)
            .addOutputs(Shape.newBuilder().addAllDimension(listOf(
                BalanceLastSeenDistributionProcessor.maxBalace, BalanceLastSeenDistributionProcessor.maxLastSeen
            )))
            .build()
    ))
    val server = ServerBuilder.forPort(port)
        .addService(componentService)
        .build()
    server.start()
    componentService.register()

    kafka.balance.stream.main(arrayOf())
    kafka.balanceLastSeen.distribution.main(arrayOf(balanceLastSeenDistributionUUID))
    kafka.blockchainGrowth.stream.main(arrayOf())
    kafka.blockRewardTick.stream.main(arrayOf())
    kafka.blockSize.stream.main(arrayOf())
    kafka.blockSizeTick.stream.main(arrayOf())
    kafka.difficulty.stream.main(arrayOf())
    kafka.difficultyTick.stream.main(arrayOf())
    kafka.ERC20Transfers.stream.main(arrayOf())
    kafka.ethereum.producer.main(arrayOf())
    kafka.ETHSupply.stream.main(arrayOf())
    kafka.feature.streams.main(arrayOf())
    kafka.gasLimit.stream.main(arrayOf())
    kafka.gasLimitTick.stream.main(arrayOf())
    kafka.gasPrice.stream.main(arrayOf())
    kafka.gasPriceTick.stream.main(arrayOf())
    kafka.gasUsed.stream.main(arrayOf())
    kafka.gasUsedTick.stream.main(arrayOf())
    kafka.lastSeen.stream.main(arrayOf())
    kafka.transactionCount.stream.main(arrayOf())
    kafka.transactionsNumber.stream.main(arrayOf())
    kafka.uniqueAccounts.stream.main(arrayOf())
    kafka.volumeIn.stream.main(arrayOf())
    kafka.volumeOut.stream.main(arrayOf())
}

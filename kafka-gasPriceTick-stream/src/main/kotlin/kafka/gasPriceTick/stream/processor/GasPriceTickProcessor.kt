package kafka.gasPriceTick.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureTickProcessor
import harvester.common.processor.FeatureCalculationStrategy
import java.math.BigDecimal

class GasPriceTickProcessor : BlockFeatureTickProcessor("gasPrice", FeatureCalculationStrategy.AVERAGE) {

    override fun extract(block: Messages.Block) {
        val averageGasPrice = averageGasPrice(block)

        updateStores(averageGasPrice)
    }

    private fun averageGasPrice(block: Messages.Block): String {
        val transactions = block.transactionsList
        if (transactions.isNullOrEmpty()) {
            return BigDecimal.ZERO.toString()
        }

        var totalGasPriceAmount = BigDecimal.ZERO
        transactions.forEach { t ->
            totalGasPriceAmount += t.gasPrice.toBigDecimal()
        }

        return (totalGasPriceAmount / transactions.size.toBigDecimal()).toString()
    }

}

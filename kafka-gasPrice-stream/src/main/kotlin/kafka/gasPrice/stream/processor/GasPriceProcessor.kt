package kafka.gasPrice.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureProcessor
import java.math.BigDecimal

class GasPriceProcessor : BlockFeatureProcessor() {
    override fun getFeatureValue(block: Messages.Block): String {
        return averageGasPrice(block)
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

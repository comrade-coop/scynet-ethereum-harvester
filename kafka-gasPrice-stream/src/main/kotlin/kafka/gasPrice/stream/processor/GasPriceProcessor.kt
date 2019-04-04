package kafka.gasPrice.stream.processor

import harvester.common.messages.Messages
import org.apache.kafka.streams.processor.Processor
import org.apache.kafka.streams.processor.ProcessorContext
import java.math.BigDecimal

class GasPriceProcessor : Processor<String, Messages.Block> {

    private var context: ProcessorContext? = null

    override fun process(blockNumber: String, block: Messages.Block) {
        try {
            process(block)
        } catch (e: Exception) {
            // TODO use logger for this
            println("Exception occurred: $e while processing block: $blockNumber")
        }
    }

    private fun process(block: Messages.Block) {
        val averageGasPrice = averageGasPrice(block)
        val blockNumber = block.number

        context!!.forward(blockNumber, averageGasPrice)
        context!!.commit()
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

    override fun init(context: ProcessorContext?) {
        this.context = context
    }

    override fun close() {}
}

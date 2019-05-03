package kafka.transactionsNumber.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.AddressFeatureTickProcessor

class TransactionsNumberProcessor: AddressFeatureTickProcessor("3600") {

    override fun extract(block: Messages.Block) {
        extractAddressTransactionsNumberFromTraces(block)
    }

    private fun addToStores(address: String) {
        addToAddressFeatureStore(address)
        addToBlockNumberAddressFeatureStore(address)
    }

    private fun extractAddressTransactionsNumberFromTraces(block: Messages.Block) {
        val traces = getTraces(block)
        traces.forEach { trace ->
            when (trace.type) {
                "reward"-> addToStores(trace.reward.author)
                "call" -> {
                    addToStores(trace.call.from)
                    addToStores(trace.call.to)
                }
                "suicide" -> {
                    addToStores(trace.suicide.address)
                    addToStores(trace.suicide.refundAddress)

                }
                "create" ->{
                    addToStores(trace.create.from)
                    addToStores(trace.result.address)
                }
            }
        }
    }

    private fun getTraces(block: Messages.Block): List<Messages.Trace>{
        return block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
    }

}

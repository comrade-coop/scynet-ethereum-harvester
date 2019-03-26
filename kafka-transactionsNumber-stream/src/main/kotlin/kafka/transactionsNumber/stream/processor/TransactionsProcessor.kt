package kafka.transactionsNumber.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureTickProcessor
import harvester.common.processor.FeatureCalculator

class TransactionsProcessor(): BlockFeatureTickProcessor() {

    override fun extract(block: Messages.Block) {
        extractAddressTransactionsNumberFromTraces(block)
    }

    override fun addToStores(address: String) {
        addToAddressTransactionNumberStore(address)
        addToBlockNumberTransactionsNumberStore(address)
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

    private fun addToAddressTransactionNumberStore(address: String) {
        val previousTransactionsNumber = addressFeatureStore!!.get(address)
        if (previousTransactionsNumber.isNullOrEmpty()) {
            addressFeatureStore!!.put(address, ONE.toString())
        } else {
            addressFeatureStore!!.put(address, FeatureCalculator.increaseByOne(previousTransactionsNumber))
        }
    }

    private fun addToBlockNumberTransactionsNumberStore(address: String) {
        val builder = blockNumberAddressFeatureStore!!.get(currentBlockNumber).toBuilder()
        val previousTransactionsNumber = builder.getAddressFeatureOrDefault(address, NEGATIVE_ONE.toString())
        if (previousTransactionsNumber == NEGATIVE_ONE.toString()) {
            builder.putAddressFeature(address, ONE.toString())
        } else {
            builder.putAddressFeature(address, FeatureCalculator.increaseByOne(previousTransactionsNumber))
        }
        blockNumberAddressFeatureStore!!.put(currentBlockNumber, builder.build())
    }

}

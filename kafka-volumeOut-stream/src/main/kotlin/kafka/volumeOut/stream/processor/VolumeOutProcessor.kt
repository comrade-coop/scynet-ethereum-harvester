package kafka.volumeOut.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.BlockFeatureTickProcessor
import harvester.common.processor.FeatureCalculator

class VolumeOutProcessor : BlockFeatureTickProcessor() {

    override fun extract(block: Messages.Block) {
        accountForGas(block)
        extractAddressVolumeOutFromTraces(block)
    }

    private fun accountForGas(block: Messages.Block) {
        block.transactionsList.forEach { transaction ->
            addToStores(transaction.from, FeatureCalculator.multiply(transaction.receipt.gasUsed, transaction.gasPrice))
        }
    }

    private fun extractAddressVolumeOutFromTraces(block: Messages.Block) {
        val traces = block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
        traces.forEach { trace ->
            when (trace.type) {
                "call" -> {
                    addToStores(trace.call.from, trace.call.value)
                }
                "suicide" -> addToStores(trace.suicide.address, trace.suicide.balance)
                "create" -> addToStores(trace.create.from, trace.create.value)
            }
        }
    }

    private fun addToStores(address: String, amount: String) {
        addToAddressVolumeOutStore(address, amount)
        addToBlockNumberAddressVolumeOutStore(address, amount)
    }

    private fun addToAddressVolumeOutStore(address: String, amount: String) {
        val previousVolumeOut = addressFeatureStore!!.get(address)
        if (previousVolumeOut.isNullOrEmpty()) {
            addressFeatureStore!!.put(address, amount)
        } else {
            addressFeatureStore!!.put(address, FeatureCalculator.sum(amount, previousVolumeOut))
        }
    }

    private fun addToBlockNumberAddressVolumeOutStore(address: String, amount: String) {
        val builder = blockNumberAddressFeatureStore!!.get(currentBlockNumber).toBuilder()
        val previousVolumeOut = builder.getAddressFeatureOrDefault(address, "-1")
        if (previousVolumeOut == "-1") {
            builder.putAddressFeature(address, amount)
        } else {
            builder.putAddressFeature(address, FeatureCalculator.sum(amount, previousVolumeOut))
        }
        blockNumberAddressFeatureStore!!.put(currentBlockNumber, builder.build())
    }

}

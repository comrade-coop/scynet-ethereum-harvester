package kafka.volumeIn.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.AddressFeatureTickProcessor
import harvester.common.processor.FeatureCalculator

class VolumeInProcessor : AddressFeatureTickProcessor(null) {


    override fun extract(block: Messages.Block) {
        accountForGas(block)
        extractAddressVolumeInFromTraces(block)
    }

    private fun addToStores(address: String, amount: String) {
        addToAddressVolumeInStore(address, amount)
        addToBlockNumberAddressVolumeInStore(address, amount)
    }

    private fun accountForGas(block: Messages.Block) {
        block.transactionsList.forEach { transaction ->
            addToStores(block.author, FeatureCalculator.multiply(transaction.receipt.gasUsed, transaction.gasPrice))
        }
    }

    private fun extractAddressVolumeInFromTraces(block: Messages.Block) {
        val traces = block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
        traces.forEach { trace ->
            when (trace.type) {
                "call" -> addToStores(trace.call.to, trace.call.value)
                "suicide" -> addToStores(trace.suicide.refundAddress, trace.suicide.balance)
                "create" -> addToStores(trace.result.address, trace.create.value)
                "reward" -> addToStores(trace.reward.author, trace.reward.value)
            }
        }
    }

    private fun addToAddressVolumeInStore(address: String, amount: String) {
        val previousVolumeIn = addressFeatureStore!!.get(address)
        if (previousVolumeIn.isNullOrEmpty()) {
            addressFeatureStore!!.put(address, amount)
        } else {
            addressFeatureStore!!.put(address, FeatureCalculator.sum(amount, previousVolumeIn))
        }
    }

    private fun addToBlockNumberAddressVolumeInStore(address: String, amount: String) {
        val builder = blockNumberAddressFeatureStore!!.get(currentBlockNumber).toBuilder()
        val previousVolumeIn = builder.getAddressFeatureOrDefault(address, "-1")
        if (previousVolumeIn == "-1") {
            builder.putAddressFeature(address, amount)
        } else {
            builder.putAddressFeature(address, FeatureCalculator.sum(amount, previousVolumeIn))
        }
        blockNumberAddressFeatureStore!!.put(currentBlockNumber, builder.build())
    }

}

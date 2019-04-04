package kafka.ERC20Transfers.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.AddressFeatureTickProcessor
import harvester.common.processor.FeatureCalculator

class ERC20TransfersProcessor: AddressFeatureTickProcessor() {

    private val TRANSFER_TOPIC = "0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"

    override fun extract(block: Messages.Block) {
        block.transactionsList.forEach { transaction ->
            transaction.receipt.logsList.forEach { log ->
                if (isERC20Transfer(log)) {
                    addToStores(transaction.to)
                }
            }
        }
    }

    private fun isERC20Transfer(log: Messages.Log): Boolean {
        return TRANSFER_TOPIC.equals(log.topicsList[0])
    }

    private fun addToStores(address: String) {
        addToAddressERC20TransfersStore(address)
        addToBlockNumberERC20TransfersStore(address)
    }

    private fun addToAddressERC20TransfersStore(address: String) {
        val previousERC20TransfersNumber = addressFeatureStore!!.get(address)
        if (previousERC20TransfersNumber.isNullOrEmpty()) {
            addressFeatureStore!!.put(address, ONE.toString())
        } else {
            addressFeatureStore!!.put(address, FeatureCalculator.increaseByOne(previousERC20TransfersNumber))
        }
    }

    private fun addToBlockNumberERC20TransfersStore(address: String) {
        val builder = blockNumberAddressFeatureStore!!.get(currentBlockNumber).toBuilder()
        val previousERCTransfersNumber = builder.getAddressFeatureOrDefault(address, NEGATIVE_ONE.toString())
        if (previousERCTransfersNumber == NEGATIVE_ONE.toString()) {
            builder.putAddressFeature(address, ONE.toString())
        } else {
            builder.putAddressFeature(address, FeatureCalculator.increaseByOne(previousERCTransfersNumber))
        }
        blockNumberAddressFeatureStore!!.put(currentBlockNumber, builder.build())
    }

}

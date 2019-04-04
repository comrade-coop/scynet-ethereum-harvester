package kafka.ERC20Transfers.stream.processor

import harvester.common.messages.Messages
import harvester.common.processor.AddressFeatureTickProcessor

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
        addToAddressFeatureStore(address)
        addToBlockNumberAddressFeatureStore(address)
    }

}

package kafka.ERC20Transfers.stream.processor

class ERC20TransfersCalculator {
    companion object {
        fun increaseByOne(ERC20TransfersNumber: String): String{
            return (ERC20TransfersNumber.toInt() + 1).toString()
        }

        fun subtract(previousERC20TransfersNumber: String, ERC20TransfersNumber: String): String{
            return (previousERC20TransfersNumber.toInt() - ERC20TransfersNumber.toInt()).toString()
        }
    }
}
package kafka.transferLogsNumber.stream.processor

class TransferLogsNumberCalculator {
    companion object {
        fun increaseByOne(transferLogsNumber: String): String{
            return (transferLogsNumber.toInt() + 1).toString()
        }

        fun subtract(previousTransferLogsNumber: String, transferLogsNumber: String): String{
            return (previousTransferLogsNumber.toInt() - transferLogsNumber.toInt()).toString()
        }
    }
}
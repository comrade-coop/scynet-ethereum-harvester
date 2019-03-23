package kafka.transferLogsCount.stream.processor

class TransferLogsCountCalculator {
    companion object {
        fun increaseByOne(transferLogsCount: String): String{
            return (transferLogsCount.toInt() + 1).toString()
        }

        fun subtract(previousTransferLogsCount: String, transferLogsCount: String): String{
            return (previousTransferLogsCount.toInt() - transferLogsCount.toInt()).toString()
        }
    }
}
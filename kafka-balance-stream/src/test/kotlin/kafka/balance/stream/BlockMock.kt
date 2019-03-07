package kafka.balance.stream

import kafka.balance.stream.messages.Messages

fun getMockedBlock(numberOfBlocks: Int, numberOfTransactionsPerBlock: Int, numberOfTracesPerTransaction: Int): List<Messages.Block> {
    val blocks = ArrayList<Messages.Block>()
    for (i in 1..numberOfBlocks) {
        val block = Messages.Block.newBuilder()
                .setAuthor("block_author")
                .addAllTransactions(getMockedTransactions(numberOfTransactionsPerBlock, numberOfTracesPerTransaction))
                .build()
        blocks.add(block)
    }
    return blocks
}

private fun getMockedTransactions(numberOfTransactions: Int, numberOfTracesPerTransaction: Int): List<Messages.Transaction> {
    val transactions = ArrayList<Messages.Transaction>()
    for (i in 1..numberOfTransactions) {
        val transaction = Messages.Transaction.newBuilder()
                .setFrom("transaction_sender")
                //.setTo("lucky_boy")
                //.setValue("100")
                .setGas("1")
                .setGasPrice("2")
                .addAllTraces(getMockedTraces(numberOfTracesPerTransaction * i - numberOfTracesPerTransaction + 1, numberOfTracesPerTransaction * i))
                .build()
        transactions.add(transaction)
    }
    return transactions
}

private fun getMockedTraces(valueRangeFrom: Int, valueRageTo: Int): List<Messages.Trace> {
    val traces = ArrayList<Messages.Trace>()
    for (i in valueRangeFrom..valueRageTo) {
        val trace = Messages.Trace.newBuilder()
                .setType("call")
                .setCall(getMockedCall(i))
                .build()
        traces.add(trace)
    }
    return traces
}

private fun getMockedCall(value: Int): Messages.Call {
    val call = Messages.Call.newBuilder()
            .setFrom("trace_sender")
            .setTo("trace_receiver")
            .setValue(value.toString())
            .build()
    return call
}

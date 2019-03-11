package kafka.lastSeen.stream.processor

import kafka.lastSeen.stream.messages.Messages

class LastSeenExtractor {
    private var addressLastSeen: HashMap<String, String>? = null

    fun extract(block: Messages.Block): HashMap<String, String>{
        addressLastSeen = HashMap()
        populateAddressLastSeen(block)
        return addressLastSeen!!
    }

    private fun populateAddressLastSeen(block: Messages.Block){
        val traces = getTraces(block)

        traces.forEach{
            trace ->
            when(trace.type){
                "reward" -> addToAddressLastSeen(trace.reward.author, block.timestamp)
                "call" -> {
                    addToAddressLastSeen(trace.call.from, block.timestamp)
                    addToAddressLastSeen(trace.call.to, block.timestamp)
                }
                "suicide" -> addToAddressLastSeen(trace.suicide.refundAddress, block.timestamp)
                "create" -> addToAddressLastSeen(trace.create.from, block.timestamp)
            }
        }
    }

    private fun getTraces(block: Messages.Block): List<Messages.Trace>{
        return block.transactionsList
                .fold(block.tracesList) { traces, transaction -> traces.union(transaction.tracesList).toList() }
    }

    private fun addToAddressLastSeen(address: String, timestamp: String){
        if(!addressLastSeen!!.containsKey(address)){
            addressLastSeen!!.put(address, timestamp)
        }
    }
}
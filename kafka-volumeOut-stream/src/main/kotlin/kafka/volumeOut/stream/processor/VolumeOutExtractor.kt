package kafka.volumeOut.stream.processor

import kafka.volumeOut.stream.messages.Messages

class VolumeOutExtractor {
    fun extract(block: Messages.Block): HashMap<String, String>{
        return HashMap()
    }
}
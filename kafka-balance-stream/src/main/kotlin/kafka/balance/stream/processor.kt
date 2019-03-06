package kafka.balance.stream

import org.apache.kafka.streams.state.KeyValueIterator
import org.apache.kafka.streams.processor.PunctuationType
import org.apache.kafka.streams.state.KeyValueStore
import org.apache.kafka.streams.processor.ProcessorContext
import org.apache.kafka.streams.processor.Processor
import java.time.Duration
import java.util.*


class WordCountProcessor : Processor<String, String> {

    private var context: ProcessorContext? = null
    private var kvStore: KeyValueStore<String, Long>? = null

    override fun init(context: ProcessorContext) {
        // keep the processor context locally because we need it in punctuate() and commit()
        this.context = context

        // retrieve the key-value store named "Counts"
        kvStore = context.getStateStore("Counts") as KeyValueStore<String, Long>

        // schedule a punctuate() method every second based on event-time
        this.context!!.schedule(Duration.ofSeconds(1), PunctuationType.STREAM_TIME){ timestamp ->
            val iter = this.kvStore!!.all()
            while (iter.hasNext()) {
                val entry = iter.next()
                context.forward(entry.key, entry.value.toString())
            }
            iter.close()

            // commit the current processing progress
            context.commit()
        }
    }

    override fun process(dummy: String, line: String) {
        val words = line.toLowerCase(Locale.getDefault()).split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        for (word in words) {
            val oldValue = this.kvStore!!.get(word).toLong()

            if (oldValue == null) {
                this.kvStore!!.put(word, 1)
            } else {
                this.kvStore!!.put(word, oldValue + 1)
            }
        }
    }

    override fun close() {
        // nothing to do
    }

}
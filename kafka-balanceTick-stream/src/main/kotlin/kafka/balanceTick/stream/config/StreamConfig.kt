package kafka.balanceTick.stream.config

import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.state.KeyValueStore
import org.apache.kafka.streams.state.StoreBuilder
import org.apache.kafka.streams.state.Stores

class StreamConfig {
    companion object {
        fun getAddressOccurrencesInTickStore(): StoreBuilder<KeyValueStore<String, Int>> {
            return Stores.keyValueStoreBuilder(
                    Stores.inMemoryKeyValueStore("AddressOccurrencesInTick"),
                    Serdes.String(),
                    Serdes.Integer()
            )
        }
    }
}
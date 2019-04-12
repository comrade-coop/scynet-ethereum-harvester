package kafka.balance.stream.config

import harvester.common.serialization.AddressFeatureSerdes
import org.apache.kafka.common.config.TopicConfig
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.streams.state.KeyValueStore
import org.apache.kafka.streams.state.StoreBuilder
import org.apache.kafka.streams.state.Stores
import java.util.*

class StreamConfig {
    companion object {
        fun getStreamProperties(): Properties {
            return Properties().apply {
                setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092")
                setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "balance")
                setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
                setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, AddressFeatureSerdes().javaClass.name)
                setProperty("cleanup.policy", TopicConfig.CLEANUP_POLICY_COMPACT) // currently set up manually
                setProperty("delete.retention.ms", "0")// currently set up manually
            }
        }

        fun getAddressBalanceStoreSupplier(): StoreBuilder<KeyValueStore<String, String>> {
            return Stores.keyValueStoreBuilder(
                    Stores.persistentKeyValueStore("AddressBalance"),
                    Serdes.String(),
                    Serdes.String()
            )
        }
    }
}
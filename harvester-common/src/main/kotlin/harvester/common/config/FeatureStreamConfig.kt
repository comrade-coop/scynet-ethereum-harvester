package harvester.common.config

import harvester.common.messages.AddressFeature
import harvester.common.serialization.AddressFeatureSerdes
import org.apache.kafka.common.config.TopicConfig
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.streams.state.KeyValueStore
import org.apache.kafka.streams.state.StoreBuilder
import org.apache.kafka.streams.state.Stores
import java.util.*

class FeatureStreamConfig {
    companion object {
        fun getStreamProperties(BOOTSTRAP_SERVERS_CONFIG: String, APPLICATION_ID_CONFIG: String): Properties {
            return Properties().apply {
                setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG)
                setProperty(StreamsConfig.APPLICATION_ID_CONFIG, APPLICATION_ID_CONFIG)
                setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
                setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, AddressFeatureSerdes().javaClass.name)
                setProperty("cleanup.policy", TopicConfig.CLEANUP_POLICY_COMPACT) // currently set up manually for Sink
                setProperty(TopicConfig.DELETE_RETENTION_MS_CONFIG, "0") // currently set up manually
            }
        }

        fun getFeatureStoreSupplier(): StoreBuilder<KeyValueStore<String, String>> {
            return Stores.keyValueStoreBuilder(
                    Stores.persistentKeyValueStore("Feature"),
                    Serdes.String(),
                    Serdes.String()
            )
        }

        fun getBlockNumberFeatureStoreSupplier(): StoreBuilder<KeyValueStore<Int, AddressFeature.AddressFeatureMap>> {
            return Stores.keyValueStoreBuilder(
                    Stores.persistentKeyValueStore("BlockNumberFeature"),
                    Serdes.Integer(),
                    AddressFeatureSerdes()
            )
        }

        fun getSynchronizationStoreSupplier(): StoreBuilder<KeyValueStore<String, String>> {
            return Stores.keyValueStoreBuilder(
                    Stores.persistentKeyValueStore("SynchronizationStore"),
                    Serdes.String(),
                    Serdes.String()
            )
        }
    }
}
package kafka.transferLogsNumber.stream.config

import kafka.transferLogsNumber.stream.messages.AddressFeature
import kafka.transferLogsNumber.stream.serialization.AddressFeatureSerdes
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
                setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:29092")
                setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "transferLogsNumber")
                setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
                setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, AddressFeatureSerdes().javaClass.name)
                setProperty("cleanup.policy", TopicConfig.CLEANUP_POLICY_COMPACT) // currently set up manually for Sink
                setProperty(TopicConfig.DELETE_RETENTION_MS_CONFIG, "0") // currently set up manually

            }
        }

        fun getAddressTransferLogsNumberStoreSupplier(): StoreBuilder<KeyValueStore<String, String>> {
            return Stores.keyValueStoreBuilder(
                    Stores.persistentKeyValueStore("AddressTransferLogsNumber"),
                    Serdes.String(),
                    Serdes.String()
            )
        }

        fun getBlockAddressTransferLogsNumberSupplier(): StoreBuilder<KeyValueStore<Int, AddressFeature.AddressFeatureMap>> {
            return Stores.keyValueStoreBuilder(
                    Stores.persistentKeyValueStore("BlockNumberAddressTransferLogsNumber"),
                    Serdes.Integer(),
                    AddressFeatureSerdes()
            )
        }

        fun getSynchronizationStoreSupplier(): StoreBuilder<KeyValueStore<String, String>>{
            return Stores.keyValueStoreBuilder(
                    Stores.persistentKeyValueStore("SynchronizationStore"),
                    Serdes.String(),
                    Serdes.String()
            )
        }
    }
}
package kafka.balance.stream.serialization

import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.serialization.Serializer



class AddressBalanceSerdes: Serde<AddressBalance.AddressBalanceMap> {

    private val addressBalanceMapSerializer = AddressBalanceMapSerializer()
    private val addressBalanceMapDeserializer = AddressBalanceMapDeserializer()

    override fun configure(map: Map<String, *>, b: Boolean) {


    }

    override fun close() {
        addressBalanceMapSerializer.close()
        addressBalanceMapDeserializer.close()

    }

    override fun serializer(): Serializer<AddressBalance.AddressBalanceMap> {
        return addressBalanceMapSerializer
    }

    override fun deserializer(): Deserializer<AddressBalance.AddressBalanceMap>? {
        return addressBalanceMapDeserializer
    }
}
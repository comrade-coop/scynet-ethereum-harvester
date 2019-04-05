package harvester.common.processor

import harvester.common.messages.AddressFeature
import java.math.BigInteger

abstract class FeatureGrowthRateTickProcessor(FEATURE: String, FEATURE_CALCULATION_STRATEGY: FeatureCalculationStrategy, TICK_TIME_SECONDS: String?)
    : BlockFeatureTickProcessor(FEATURE, FEATURE_CALCULATION_STRATEGY, TICK_TIME_SECONDS) {

    private val PREVIOUS_TICK_FEATURE_VALUE = "PREVIOUS_TICK_FEATURE_VALUE"

    override fun buildFeatureMap(): AddressFeature.AddressFeatureMap {
        val builder = AddressFeature.AddressFeatureMap.newBuilder()

        val featureValue = featureStore!!.get(FEATURE)
        val previousTickFeatureValue = getPreviousTickFeatureValue()
        val growthRate = FeatureCalculator.divide(featureValue, previousTickFeatureValue, 4)

        return builder.putAddressFeature(FEATURE, growthRate).build()
    }

    private fun getPreviousTickFeatureValue(): String {
        val featureValue = featureStore!!.get(PREVIOUS_TICK_FEATURE_VALUE)
        if (featureValue != null) {
            return featureValue
        }
        return BigInteger.ONE.toString()
    }

    override fun updatePreviousTickFeatureValue() {
        val featureValue = featureStore!!.get(FEATURE)
        featureStore!!.put(PREVIOUS_TICK_FEATURE_VALUE, featureValue)
    }
}
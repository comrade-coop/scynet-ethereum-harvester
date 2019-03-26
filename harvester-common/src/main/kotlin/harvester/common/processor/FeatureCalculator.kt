package harvester.common.processor

class FeatureCalculator {
    companion object {
        fun increaseByOne(featureNumber: String): String {
            return (featureNumber.toInt() + 1).toString()
        }

        fun subtract(previousFeatureNumber: String, featureNumber: String): String {
            return (previousFeatureNumber.toInt() - featureNumber.toInt()).toString()
        }
    }
}
package kafka.feature.streams

import harvester.common.processor.FeatureCalculationStrategy

class FeatureStream(private val FEATURE: String,
                    private val FeatureStreamType: FeatureProcessorType,
                    private val FeatureCalculationStrategy: FeatureCalculationStrategy) {

}
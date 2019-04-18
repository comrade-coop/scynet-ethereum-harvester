package harvester.common.distribution.scaler

interface IScaler {
    fun scaleDown(feature: String): Int
}

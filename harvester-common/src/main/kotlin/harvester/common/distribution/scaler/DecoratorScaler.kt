package harvester.common.distribution.scaler

abstract class DecoratorScaler(inner : IScaler): IScaler {
    private val core: IScaler = inner

    override fun scaleDown(feature: String): Int {
        return core.scaleDown(feature)
    }
}
package harvester.common.distribution.scaler

import kotlin.math.roundToInt

class LogOnePointTwoScaler: IScaler {
    override fun scaleDown(feature: String): Int {
        val feature = feature.toDouble()
        if(feature < 1){
            return  0
        }
        return (Math.log10(feature)/Math.log10(1.2)).roundToInt()
    }
}
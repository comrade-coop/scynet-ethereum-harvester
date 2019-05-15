package harvester.common.distribution.scaler

import kotlin.math.roundToInt

class LogTwoScaler: IScaler {
    override fun scaleDown(feature: String): Int {
        val feature = feature.toDouble()
        if(feature < 1){
            return  0
        }
        return (Math.log10(feature)/Math.log10(2.0)).roundToInt()
    }
}
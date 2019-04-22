package kafka.balanceLastSeen.distribution.processor

import harvester.common.distribution.scaler.IScaler
import harvester.common.messages.StringList
import harvester.common.processor.DistributionProcessor
import kotlin.math.roundToInt

class BalanceLastSeenDistributionProcessor(balanceScaler: IScaler, lastSeenScaler: IScaler): DistributionProcessor(maxBalace, maxLastSeen, balanceScaler, lastSeenScaler) {

    private val blocksInMonth: Int = 25920

    companion object {
        private val maxBalace: Int = (Math.log10(10000000.0) / Math.log10(1.2)).roundToInt()
        private val maxLastSeen: Int = (Math.log10(20736000.0) / Math.log10(1.2)).roundToInt()
    }

    override fun updatePositionsAfterDistributingCurrentAddresses() {
        val addressPositions = addressPositionStore!!.all()
        addressPositions.forEach { addressPosition ->
            if(isInCurrentBlock(addressPosition.value)) return@forEach
            removeFromMatrix(calculatePositionInBlobData(addressPosition.value))
            if (isOutdated(addressPosition.value)) {
                addressPositionStore!!.delete(addressPosition.key)
                return@forEach
            }
            distribute(addressPosition.key, addressPosition.value)
        }
        addressPositions.close()
    }

    private fun isInCurrentBlock(position: StringList.List): Boolean{
        if(position.getItem(2) == currentBlock.toString()) return true
        return false
    }

    private fun isOutdated(position: StringList.List): Boolean{
        if(position.getItem(2).toInt() < currentBlock!!.minus(blocksInMonth)) return true
        return false
    }

    override fun getGroup1(feature1:String): Int{
        return Math.min(scaler1.scaleDown((currentTimestamp!!.toBigInteger() - feature1.toBigInteger()).toString()), max1 - 1)
    }
}
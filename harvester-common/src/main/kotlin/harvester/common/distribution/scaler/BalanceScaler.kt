package harvester.common.distribution.scaler

import java.math.BigInteger

class BalanceScaler(inner: IScaler): DecoratorScaler(inner) {

    private val divideWeiToGetTenthOfEthereum = BigInteger.valueOf(100000000000000000)

    override fun scaleDown(feature: String): Int{
        val balanceInTenthOfEth = weiToTenthOfEth(feature)
        return super.scaleDown(balanceInTenthOfEth)
    }

    private fun weiToTenthOfEth(balance: String?): String{
        return (balance!!.toBigInteger() / divideWeiToGetTenthOfEthereum).toString()
    }
}
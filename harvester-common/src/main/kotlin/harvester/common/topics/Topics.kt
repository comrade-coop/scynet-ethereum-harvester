package harvester.common.topics

enum class Topics: ITopic {
    BALANCE{
        override fun spell() = "Balance"

    },
    BALANCE_TICK{
        override fun spell() = "BalanceTick"
    },
    LAST_SEEN{
        override fun spell() = "LastSeen"
    },
    VOLUME_OUT{
        override fun spell() = "VolumeOut"
    },
    VOLUME_IN{
        override fun spell() = "VolumeIn"
    },
    TRANSACTIONS_N{
        override fun spell() = "TransactionsN"
    };
}
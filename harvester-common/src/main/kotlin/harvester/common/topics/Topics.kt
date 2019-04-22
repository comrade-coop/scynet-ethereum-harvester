package harvester.common.topics

enum class Topics: ITopic {
    BALANCE{
        override fun spell() = "Balance"

    },
    LAST_SEEN{
        override fun spell() = "LastSeen"
    },
    VOLUME_OUT{
        override fun spell() = "VolumeOut"
    };
}
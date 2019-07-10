package com.knowyourplace.datamodels

import java.util.*

data class PlayerInfo(val username: String, val name: String)

data class Player(val uuid: UUID, val info: PlayerInfo)
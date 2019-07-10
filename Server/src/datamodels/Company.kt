package com.knowyourplace.datamodels

import java.util.*


data class Company(val uuid: UUID, val name: String) {

    fun addPlayer(info: PlayerInfo): Player = Player(UUID.randomUUID(), info)
}
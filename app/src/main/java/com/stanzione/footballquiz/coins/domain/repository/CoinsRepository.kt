package com.stanzione.footballquiz.coins.domain.repository

interface CoinsRepository {
    fun getCoins(): Int
    fun addCoins(coins: Int)
    fun removeCoins(coins: Int)
}
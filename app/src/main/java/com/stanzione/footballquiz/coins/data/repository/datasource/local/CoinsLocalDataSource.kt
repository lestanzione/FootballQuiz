package com.stanzione.footballquiz.coins.data.repository.datasource.local

interface CoinsLocalDataSource {
    fun getCoins(): Int
    fun addCoins(coins: Int)
    fun removeCoins(coins: Int)
}
package com.stanzione.footballquiz.coins.data.repository

import com.stanzione.footballquiz.coins.data.repository.datasource.local.CoinsLocalDataSource
import com.stanzione.footballquiz.coins.domain.repository.CoinsRepository

class CoinsRepositoryImpl(
    private val coinsLocalDataSource: CoinsLocalDataSource
): CoinsRepository {
    override fun getCoins(): Int {
        return coinsLocalDataSource.getCoins()
    }

    override fun addCoins(coins: Int) {
        coinsLocalDataSource.addCoins(coins)
    }

    override fun removeCoins(coins: Int) {
        coinsLocalDataSource.removeCoins(coins)
    }
}
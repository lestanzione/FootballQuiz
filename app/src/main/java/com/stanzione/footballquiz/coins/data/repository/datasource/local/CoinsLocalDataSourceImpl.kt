package com.stanzione.footballquiz.coins.data.repository.datasource.local

class CoinsLocalDataSourceImpl : CoinsLocalDataSource {
    private var coins: Int = 0

    override fun getCoins(): Int {
        return coins
    }

    override fun addCoins(coins: Int) {
        this.coins += coins
    }

    override fun removeCoins(coins: Int) {
        this.coins -= coins
    }
}
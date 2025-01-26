package com.stanzione.footballquiz.coins.domain.usecase

import com.stanzione.footballquiz.coins.domain.repository.CoinsRepository

class RemoveCoinsUseCaseImpl(
    private val coinsRepository: CoinsRepository
) : RemoveCoinsUseCase {
    override fun execute(coins: Int) {
        coinsRepository.removeCoins(coins)
    }
}
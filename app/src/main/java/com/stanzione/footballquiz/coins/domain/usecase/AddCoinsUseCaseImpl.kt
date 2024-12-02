package com.stanzione.footballquiz.coins.domain.usecase

import com.stanzione.footballquiz.coins.domain.repository.CoinsRepository

class AddCoinsUseCaseImpl(
    private val coinsRepository: CoinsRepository
) : AddCoinsUseCase {
    override fun execute(coins: Int) {
        coinsRepository.addCoins(coins)
    }
}
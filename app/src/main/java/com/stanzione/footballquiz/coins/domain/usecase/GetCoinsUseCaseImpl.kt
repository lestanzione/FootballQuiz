package com.stanzione.footballquiz.coins.domain.usecase

import com.stanzione.footballquiz.coins.domain.repository.CoinsRepository

class GetCoinsUseCaseImpl(
    private val coinsRepository: CoinsRepository
) : GetCoinsUseCase {
    override fun execute(): Int {
        return coinsRepository.getCoins()
    }
}
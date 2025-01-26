package com.stanzione.footballquiz.levels.domain.usecase

import com.stanzione.footballquiz.levels.domain.repository.LevelRepository

class UnlockLevelUseCaseImpl(
    private val levelRepository: LevelRepository
) : UnlockLevelUseCase {
    override fun execute(levelId: Int) {
        levelRepository.addUnlockedLevel(levelId)
    }
}
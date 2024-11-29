package com.stanzione.footballquiz.optionsgame.domain.usecase

import com.stanzione.footballquiz.score.domain.repository.ScoreRepository

class UpdateLevelScoreUseCaseImpl(
    private val scoreRepository: ScoreRepository
) : UpdateLevelScoreUseCase {
    override fun execute(levelId: Int, score: Int) {
        scoreRepository.setScore(levelId, score)
    }
}
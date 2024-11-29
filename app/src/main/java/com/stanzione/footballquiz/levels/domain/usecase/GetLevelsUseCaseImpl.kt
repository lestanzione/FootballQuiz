package com.stanzione.footballquiz.levels.domain.usecase

import com.stanzione.footballquiz.levels.data.model.Level
import com.stanzione.footballquiz.levels.domain.repository.LevelRepository
import com.stanzione.footballquiz.score.domain.repository.ScoreRepository

class GetLevelsUseCaseImpl(
    private val levelRepository: LevelRepository,
    private val scoreRepository: ScoreRepository
) : GetLevelsUseCase {
    override fun execute(categoryId: Int): List<Level> {

        val levels = levelRepository.getLevelsByCategoryId(categoryId)
        val score = scoreRepository.getTotalScore()
        println("LSTAN - score: $score")

        levels.forEach { level ->
            level.enabled = score >= level.minScoreToUnlock
            level.score = scoreRepository.getScore(level.id)
        }

        return levels
    }
}
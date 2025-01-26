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
        val unlockedLevelIds = levelRepository.getAllUnlockedLevelIds()
        val score = scoreRepository.getTotalScore()
        println("LSTAN - score: $score")

        levels.forEach { level ->
            level.enabled = isLevelUnlocked(
                level,
                score,
                unlockedLevelIds
            )
            level.score = scoreRepository.getScore(level.id)
        }

        return levels
    }

    private fun isLevelUnlocked(level: Level, score: Int, unlockedLevelIds: List<Int>): Boolean {
        if (unlockedLevelIds.contains(level.id)) {
            return true
        }

        if (score >= level.minScoreToUnlock) {
            return true
        }

        return false
    }
}
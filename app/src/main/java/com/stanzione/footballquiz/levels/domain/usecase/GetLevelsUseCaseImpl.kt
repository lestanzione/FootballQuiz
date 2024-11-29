package com.stanzione.footballquiz.levels.domain.usecase

import com.stanzione.footballquiz.levels.data.model.Level
import com.stanzione.footballquiz.levels.domain.repository.LevelRepository
import com.stanzione.footballquiz.points.domain.repository.PointRepository

class GetLevelsUseCaseImpl(
    private val levelRepository: LevelRepository,
    private val pointRepository: PointRepository
) : GetLevelsUseCase {
    override fun execute(categoryId: Int): List<Level> {

        val levels = levelRepository.getLevelsByCategoryId(categoryId)
        val points = pointRepository.getTotalPoints()
        println("LSTAN - points: $points")

        levels.forEach { level ->
            level.enabled = points >= level.minScoreToUnlock
            level.score = pointRepository.getPoints(level.id)
        }

        return levels
    }
}
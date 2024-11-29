package com.stanzione.footballquiz.levels.domain.usecase

import com.stanzione.footballquiz.levels.data.model.Level
import com.stanzione.footballquiz.levels.domain.repository.LevelRepository
import com.stanzione.footballquiz.points.domain.repository.PointRepository

class GetLevelsUseCaseImpl(
    private val levelRepository: LevelRepository,
    private val pointRepository: PointRepository
) : GetLevelsUseCase {
    override fun invoke(categoryId: Int): List<Level> {

        val levels = levelRepository.getLevelsByCategoryId(categoryId)
        val points = pointRepository.getPoints()

        levels.forEach { level ->
            level.enabled = points >= level.minScoreToUnlock
        }

        return levels
    }
}
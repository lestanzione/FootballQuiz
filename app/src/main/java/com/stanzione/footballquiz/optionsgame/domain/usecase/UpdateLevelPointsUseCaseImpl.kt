package com.stanzione.footballquiz.optionsgame.domain.usecase

import com.stanzione.footballquiz.points.domain.repository.PointRepository

class UpdateLevelPointsUseCaseImpl(
    private val pointRepository: PointRepository
) : UpdateLevelPointsUseCase {
    override fun execute(levelId: Int, point: Int) {
        pointRepository.setPoints(levelId, point)
    }
}
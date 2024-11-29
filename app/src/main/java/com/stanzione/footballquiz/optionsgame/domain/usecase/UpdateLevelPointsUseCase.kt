package com.stanzione.footballquiz.optionsgame.domain.usecase

interface UpdateLevelPointsUseCase {
    fun execute(levelId: Int, point: Int)
}
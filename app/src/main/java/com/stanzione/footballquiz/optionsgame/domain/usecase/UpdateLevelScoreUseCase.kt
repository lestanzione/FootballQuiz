package com.stanzione.footballquiz.optionsgame.domain.usecase

interface UpdateLevelScoreUseCase {
    fun execute(levelId: Int, score: Int)
}
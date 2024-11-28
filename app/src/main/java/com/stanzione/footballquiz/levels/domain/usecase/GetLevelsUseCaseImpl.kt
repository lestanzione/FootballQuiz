package com.stanzione.footballquiz.levels.domain.usecase

import com.stanzione.footballquiz.levels.data.model.Level
import com.stanzione.footballquiz.levels.domain.repository.LevelRepository

class GetLevelsUseCaseImpl(
    private val levelRepository: LevelRepository
) : GetLevelsUseCase {
    override fun invoke(categoryId: Int): List<Level> {
        return levelRepository.getLevelsByCategoryId(categoryId)
    }
}
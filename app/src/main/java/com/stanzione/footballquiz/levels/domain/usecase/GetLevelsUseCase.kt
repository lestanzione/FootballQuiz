package com.stanzione.footballquiz.levels.domain.usecase

import com.stanzione.footballquiz.levels.data.model.Level

interface GetLevelsUseCase {
    fun execute(categoryId: Int): List<Level>
}
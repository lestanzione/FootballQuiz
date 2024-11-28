package com.stanzione.footballquiz.levels.domain.repository

import com.stanzione.footballquiz.levels.data.model.Level

interface LevelRepository {
    fun getLevelsByCategoryId(categoryId: Int): List<Level>
}
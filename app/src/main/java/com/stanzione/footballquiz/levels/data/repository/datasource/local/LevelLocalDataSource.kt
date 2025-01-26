package com.stanzione.footballquiz.levels.data.repository.datasource.local

import com.stanzione.footballquiz.levels.data.model.Level

interface LevelLocalDataSource {
    fun getLevelsByCategoryId(categoryId: Int): List<Level>
    fun getAllUnlockedLevelIds(): List<Int>
    fun addUnlockedLevel(levelId: Int)
}
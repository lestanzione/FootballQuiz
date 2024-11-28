package com.stanzione.footballquiz.levels.data.repository.datasource.local

import com.stanzione.footballquiz.levels.data.model.Level

class LevelLocalDataSourceImpl : LevelLocalDataSource {
    override fun getLevelsByCategoryId(categoryId: Int): List<Level> {
        return getAllLevels()
            .filter { level ->
                level.categoryId == categoryId
            }
    }

    private fun getAllLevels(): List<Level> {
        return emptyList()
    }
}
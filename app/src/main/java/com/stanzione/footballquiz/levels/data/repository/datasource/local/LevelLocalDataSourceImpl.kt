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
        return listOf(
            Level(
                id = 1,
                label = "Level 1",
                enabled = true,
                questions = 10,
                score = 0,
                categoryId = 1
            ),
            Level(
                id = 2,
                label = "Level 2",
                enabled = false,
                questions = 10,
                score = 0,
                categoryId = 1
            ),
            Level(
                id = 3,
                label = "Level 3",
                enabled = false,
                questions = 10,
                score = 0,
                categoryId = 1
            ),
            Level(
                id = 1000,
                label = "Level 1",
                enabled = true,
                questions = 10,
                score = 0,
                categoryId = 2
            ),
        )
    }
}
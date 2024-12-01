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
                questions = 10,
                minScoreToUnlock = 0,
                categoryId = 1,
                enabled = true,
                score = 0,
            ),
            Level(
                id = 2,
                label = "Level 2",
                questions = 10,
                minScoreToUnlock = 2,
                categoryId = 1,
                enabled = false,
                score = 0,
            ),
            Level(
                id = 3,
                label = "Level 3",
                questions = 10,
                minScoreToUnlock = 5,
                categoryId = 1,
                enabled = false,
                score = 0,
            ),
            Level(
                id = 1000,
                label = "Level 1",
                questions = 10,
                minScoreToUnlock = 0,
                categoryId = 2,
                enabled = true,
                score = 0,
            ),
        )
    }
}
package com.stanzione.footballquiz.levels.data.repository

import com.stanzione.footballquiz.levels.data.model.Level
import com.stanzione.footballquiz.levels.data.repository.datasource.local.LevelLocalDataSource
import com.stanzione.footballquiz.levels.domain.repository.LevelRepository

class LevelRepositoryImpl(
    private val levelLocalDataSource: LevelLocalDataSource
) : LevelRepository {
    override fun getLevelsByCategoryId(categoryId: Int): List<Level> {
        return levelLocalDataSource.getLevelsByCategoryId(categoryId)
    }

    override fun getAllUnlockedLevelIds(): List<Int> {
        return levelLocalDataSource.getAllUnlockedLevelIds()
    }

    override fun addUnlockedLevel(levelId: Int) {
        levelLocalDataSource.addUnlockedLevel(levelId)
    }
}
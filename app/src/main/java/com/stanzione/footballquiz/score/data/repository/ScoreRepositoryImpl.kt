package com.stanzione.footballquiz.score.data.repository

import com.stanzione.footballquiz.score.domain.repository.ScoreRepository

class ScoreRepositoryImpl : ScoreRepository {
    private val levelScoresMap = mutableMapOf<Int, Int>()

    override fun getTotalScore(): Int {
        return levelScoresMap.values.sum()
    }

    override fun getScore(levelId: Int): Int {
        return levelScoresMap[levelId] ?: 0
    }

    override fun setScore(levelId: Int, score: Int) {
        levelScoresMap[levelId] = score
    }
}
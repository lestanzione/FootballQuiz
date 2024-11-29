package com.stanzione.footballquiz.points.data.repository

import com.stanzione.footballquiz.points.domain.repository.PointRepository

class PointRepositoryImpl : PointRepository {
    private val levelPointsMap = mutableMapOf<Int, Int>()

    override fun getTotalPoints(): Int {
        return levelPointsMap.values.sum()
    }

    override fun getPoints(levelId: Int): Int {
        return levelPointsMap[levelId] ?: 0
    }

    override fun setPoints(levelId: Int, points: Int) {
        levelPointsMap[levelId] = points
    }
}
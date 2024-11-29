package com.stanzione.footballquiz.points.data.repository

import com.stanzione.footballquiz.points.domain.repository.PointRepository

class PointRepositoryImpl : PointRepository {
    private val levelPointsMap = mutableMapOf<Int, Int>()

    override fun getPoints(): Int {
        return levelPointsMap.values.sum()
    }

    override fun setPoints(levelId: Int, points: Int) {
        levelPointsMap[levelId] = points
    }
}
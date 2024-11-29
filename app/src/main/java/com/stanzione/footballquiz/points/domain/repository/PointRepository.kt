package com.stanzione.footballquiz.points.domain.repository

interface PointRepository {
    fun getTotalPoints(): Int
    fun getPoints(levelId: Int): Int
    fun setPoints(levelId: Int, points: Int)
}
package com.stanzione.footballquiz.points.domain.repository

interface PointRepository {
    fun getPoints(): Int
    fun setPoints(levelId: Int, points: Int)
}
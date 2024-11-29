package com.stanzione.footballquiz.score.domain.repository

interface ScoreRepository {
    fun getTotalScore(): Int
    fun getScore(levelId: Int): Int
    fun setScore(levelId: Int, score: Int)
}
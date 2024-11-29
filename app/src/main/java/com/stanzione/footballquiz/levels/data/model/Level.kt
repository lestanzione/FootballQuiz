package com.stanzione.footballquiz.levels.data.model

data class Level(
    val id: Int,
    val label: String,
    val questions: Int,
    val minScoreToUnlock: Int,
    val categoryId: Int,
    var enabled: Boolean,
    var score: Int,
)

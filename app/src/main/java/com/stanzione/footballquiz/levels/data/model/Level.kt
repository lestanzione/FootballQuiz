package com.stanzione.footballquiz.levels.data.model

data class Level(
    val id: Int,
    val label: String,
    val enabled: Boolean,
    val questions: Int,
    val score: Int,
    val categoryId: Int,
)

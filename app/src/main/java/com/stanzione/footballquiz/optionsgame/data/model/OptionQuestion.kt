package com.stanzione.footballquiz.optionsgame.data.model

data class OptionQuestion(
    val title: String,
    val imageUrl: String,
    val optionList: List<String>,
    val answerIndex: Int,
    val levelId: List<Int>
)

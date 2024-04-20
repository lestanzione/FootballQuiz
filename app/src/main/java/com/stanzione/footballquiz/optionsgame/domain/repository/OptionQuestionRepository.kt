package com.stanzione.footballquiz.optionsgame.domain.repository

import com.stanzione.footballquiz.optionsgame.data.model.OptionQuestion

interface OptionQuestionRepository {

    suspend fun getQuestions(): List<OptionQuestion>

}
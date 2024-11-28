package com.stanzione.footballquiz.optionsgame.data.repository.local.datasource

import com.stanzione.footballquiz.optionsgame.data.model.OptionQuestion

interface OptionQuestionLocalDataSource {

    suspend fun getQuestions(levelId: Int): List<OptionQuestion>

}
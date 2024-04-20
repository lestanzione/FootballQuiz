package com.stanzione.footballquiz.optionsgame.data.repository.remote.datasource

import com.stanzione.footballquiz.optionsgame.data.model.OptionQuestion

interface OptionQuestionRemoteDataSource {

    suspend fun getQuestions(): List<OptionQuestion>

}
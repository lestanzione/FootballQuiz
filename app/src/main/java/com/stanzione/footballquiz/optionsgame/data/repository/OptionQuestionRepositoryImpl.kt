package com.stanzione.footballquiz.optionsgame.data.repository

import com.stanzione.footballquiz.optionsgame.data.model.OptionQuestion
import com.stanzione.footballquiz.optionsgame.data.repository.remote.datasource.OptionQuestionRemoteDataSource
import com.stanzione.footballquiz.optionsgame.domain.repository.OptionQuestionRepository

class OptionQuestionRepositoryImpl(
    private val optionQuestionRemoteDataSource: OptionQuestionRemoteDataSource
) : OptionQuestionRepository {

    override suspend fun getQuestions(): List<OptionQuestion> {
        return optionQuestionRemoteDataSource.getQuestions()
    }

}
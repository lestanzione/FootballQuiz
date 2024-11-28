package com.stanzione.footballquiz.optionsgame.data.repository

import com.stanzione.footballquiz.optionsgame.data.model.OptionQuestion
import com.stanzione.footballquiz.optionsgame.data.repository.local.datasource.OptionQuestionLocalDataSource
import com.stanzione.footballquiz.optionsgame.data.repository.remote.datasource.OptionQuestionRemoteDataSource
import com.stanzione.footballquiz.optionsgame.domain.repository.OptionQuestionRepository

class OptionQuestionRepositoryImpl(
    private val optionQuestionRemoteDataSource: OptionQuestionRemoteDataSource,
    private val optionQuestionLocalDataSource: OptionQuestionLocalDataSource,
) : OptionQuestionRepository {

    override suspend fun getQuestions(levelId: Int): List<OptionQuestion> {
        val shouldUseLocalDataSource = true
        return if (shouldUseLocalDataSource) {
            optionQuestionLocalDataSource.getQuestions(levelId)
        } else {
            optionQuestionRemoteDataSource.getQuestions()
        }
    }

}
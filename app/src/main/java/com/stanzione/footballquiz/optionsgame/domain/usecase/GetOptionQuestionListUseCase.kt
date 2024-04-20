package com.stanzione.footballquiz.optionsgame.domain.usecase

import com.stanzione.footballquiz.optionsgame.data.model.OptionQuestion

interface GetOptionQuestionListUseCase {
    suspend fun execute(): List<OptionQuestion>
}
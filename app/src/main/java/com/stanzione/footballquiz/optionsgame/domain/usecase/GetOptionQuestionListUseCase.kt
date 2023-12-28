package com.stanzione.footballquiz.optionsgame.domain.usecase

import com.stanzione.footballquiz.optionsgame.data.model.OptionQuestion

interface GetOptionQuestionListUseCase {
    fun execute(): List<OptionQuestion>
}
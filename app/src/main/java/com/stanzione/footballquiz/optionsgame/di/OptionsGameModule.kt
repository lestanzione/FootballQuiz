package com.stanzione.footballquiz.optionsgame.di

import com.stanzione.footballquiz.optionsgame.domain.usecase.GetOptionQuestionListUseCase
import com.stanzione.footballquiz.optionsgame.domain.usecase.GetOptionQuestionListUseCaseImpl
import com.stanzione.footballquiz.optionsgame.presentation.OptionsGameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val optionsGameModule = module {
    viewModel {
        OptionsGameViewModel(
            getOptionQuestionListUseCase = get()
        )
    }

    single<GetOptionQuestionListUseCase> {
        GetOptionQuestionListUseCaseImpl()
    }
}
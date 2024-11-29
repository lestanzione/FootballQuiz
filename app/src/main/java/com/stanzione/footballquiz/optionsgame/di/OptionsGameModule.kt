package com.stanzione.footballquiz.optionsgame.di

import com.google.firebase.firestore.FirebaseFirestore
import com.stanzione.footballquiz.optionsgame.data.mapper.OptionQuestionMapper
import com.stanzione.footballquiz.optionsgame.data.mapper.OptionQuestionMapperImpl
import com.stanzione.footballquiz.optionsgame.data.repository.OptionQuestionRepositoryImpl
import com.stanzione.footballquiz.optionsgame.data.repository.local.datasource.OptionQuestionLocalDataSource
import com.stanzione.footballquiz.optionsgame.data.repository.local.datasource.OptionQuestionLocalDataSourceImpl
import com.stanzione.footballquiz.optionsgame.data.repository.remote.datasource.OptionQuestionRemoteDataSource
import com.stanzione.footballquiz.optionsgame.data.repository.remote.datasource.OptionQuestionRemoteDataSourceImpl
import com.stanzione.footballquiz.optionsgame.domain.repository.OptionQuestionRepository
import com.stanzione.footballquiz.optionsgame.domain.usecase.GetOptionQuestionListUseCase
import com.stanzione.footballquiz.optionsgame.domain.usecase.GetOptionQuestionListUseCaseImpl
import com.stanzione.footballquiz.optionsgame.domain.usecase.UpdateLevelScoreUseCase
import com.stanzione.footballquiz.optionsgame.domain.usecase.UpdateLevelScoreUseCaseImpl
import com.stanzione.footballquiz.optionsgame.presentation.OptionsGameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val optionsGameModule = module {
    viewModel {
        OptionsGameViewModel(
            getOptionQuestionListUseCase = get(),
            updateLevelScoreUseCase = get(),
        )
    }

    single<GetOptionQuestionListUseCase> {
        GetOptionQuestionListUseCaseImpl(
            optionQuestionRepository = get()
        )
    }

    single<UpdateLevelScoreUseCase> {
        UpdateLevelScoreUseCaseImpl(
            scoreRepository = get()
        )
    }

    single<OptionQuestionRepository> {
        OptionQuestionRepositoryImpl(
            optionQuestionRemoteDataSource = get(),
            optionQuestionLocalDataSource = get()
        )
    }

    single<OptionQuestionRemoteDataSource> {
        OptionQuestionRemoteDataSourceImpl(
            firestore = FirebaseFirestore.getInstance(),
            mapper = get()
        )
    }

    single<OptionQuestionLocalDataSource> {
        OptionQuestionLocalDataSourceImpl()
    }

    single<OptionQuestionMapper> {
        OptionQuestionMapperImpl()
    }
}
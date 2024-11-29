package com.stanzione.footballquiz.levels.di

import com.stanzione.footballquiz.levels.data.repository.LevelRepositoryImpl
import com.stanzione.footballquiz.levels.data.repository.datasource.local.LevelLocalDataSource
import com.stanzione.footballquiz.levels.data.repository.datasource.local.LevelLocalDataSourceImpl
import com.stanzione.footballquiz.levels.domain.repository.LevelRepository
import com.stanzione.footballquiz.levels.domain.usecase.GetLevelsUseCase
import com.stanzione.footballquiz.levels.domain.usecase.GetLevelsUseCaseImpl
import com.stanzione.footballquiz.levels.presentation.LevelsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val levelModule = module {
    single<LevelLocalDataSource> {
        LevelLocalDataSourceImpl()
    }

    single<LevelRepository> {
        LevelRepositoryImpl(
            levelLocalDataSource = get()
        )
    }

    single<GetLevelsUseCase> {
        GetLevelsUseCaseImpl(
            levelRepository = get(),
            pointRepository = get()
        )
    }

    viewModel { params ->
        LevelsViewModel(
            getLevelsUseCase = get(),
            levelsNavigation = params.get()
        )
    }
}
package com.stanzione.footballquiz.main.di

import com.stanzione.footballquiz.category.data.repository.CategoryRepositoryImpl
import com.stanzione.footballquiz.category.data.repository.datasource.local.CategoryLocalDataSource
import com.stanzione.footballquiz.category.data.repository.datasource.local.CategoryLocalDataSourceImpl
import com.stanzione.footballquiz.category.domain.repository.CategoryRepository
import com.stanzione.footballquiz.category.domain.usecase.GetCategoriesUseCase
import com.stanzione.footballquiz.category.domain.usecase.GetCategoriesUseCaseImpl
import com.stanzione.footballquiz.main.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel { params ->
        MainViewModel(
            getCategoriesUseCase = get(),
            mainNavigation = params.get()
        )
    }

}
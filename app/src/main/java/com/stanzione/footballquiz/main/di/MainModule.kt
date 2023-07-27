package com.stanzione.footballquiz.main.di

import com.stanzione.footballquiz.main.data.repository.CategoryRepositoryImpl
import com.stanzione.footballquiz.main.data.repository.datasource.local.CategoryLocalDataSource
import com.stanzione.footballquiz.main.data.repository.datasource.local.CategoryLocalDataSourceImpl
import com.stanzione.footballquiz.main.domain.repository.CategoryRepository
import com.stanzione.footballquiz.main.domain.usecase.GetCategoriesUseCase
import com.stanzione.footballquiz.main.domain.usecase.GetCategoriesUseCaseImpl
import com.stanzione.footballquiz.main.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    single<CategoryLocalDataSource> {
        CategoryLocalDataSourceImpl()
    }

    single<CategoryRepository> {
        CategoryRepositoryImpl(
            categoryLocalDataSource = get()
        )
    }

    single<GetCategoriesUseCase> {
        GetCategoriesUseCaseImpl(
            categoryRepository = get()
        )
    }

    viewModel {
        MainViewModel(
            getCategoriesUseCase = get()
        )
    }

}
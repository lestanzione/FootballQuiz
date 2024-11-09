package com.stanzione.footballquiz.category.di

import com.stanzione.footballquiz.category.data.repository.CategoryRepositoryImpl
import com.stanzione.footballquiz.category.data.repository.datasource.local.CategoryLocalDataSource
import com.stanzione.footballquiz.category.data.repository.datasource.local.CategoryLocalDataSourceImpl
import com.stanzione.footballquiz.category.domain.repository.CategoryRepository
import com.stanzione.footballquiz.category.domain.usecase.GetCategoriesUseCase
import com.stanzione.footballquiz.category.domain.usecase.GetCategoriesUseCaseImpl
import com.stanzione.footballquiz.category.presentation.CategoriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val categoryModule = module {
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

    viewModel { params ->
        CategoriesViewModel(
            getCategoriesUseCase = get(),
            categoriesNavigation = params.get(),
        )
    }
}

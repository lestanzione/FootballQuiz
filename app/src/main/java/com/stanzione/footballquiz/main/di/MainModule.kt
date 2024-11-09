package com.stanzione.footballquiz.main.di

import com.stanzione.footballquiz.main.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel { params ->
        MainViewModel(
            mainNavigation = params.get()
        )
    }
}

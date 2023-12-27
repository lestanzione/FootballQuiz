package com.stanzione.footballquiz.scrambledgame.di

import com.stanzione.footballquiz.scrambledgame.ScrambledGameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val scrambledGameModule = module {

    viewModel {
        ScrambledGameViewModel()
    }

}
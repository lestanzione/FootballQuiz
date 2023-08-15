package com.stanzione.footballquiz.game.di

import com.stanzione.footballquiz.game.GameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val gameModule = module {

    viewModel {
        GameViewModel()
    }

}
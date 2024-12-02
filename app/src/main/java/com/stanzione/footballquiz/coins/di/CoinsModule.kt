package com.stanzione.footballquiz.coins.di

import com.stanzione.footballquiz.coins.data.repository.CoinsRepositoryImpl
import com.stanzione.footballquiz.coins.data.repository.datasource.local.CoinsLocalDataSource
import com.stanzione.footballquiz.coins.data.repository.datasource.local.CoinsLocalDataSourceImpl
import com.stanzione.footballquiz.coins.domain.repository.CoinsRepository
import com.stanzione.footballquiz.coins.domain.usecase.GetCoinsUseCase
import com.stanzione.footballquiz.coins.domain.usecase.GetCoinsUseCaseImpl
import org.koin.dsl.module

val coinsModule = module {
    single<CoinsLocalDataSource> {
        CoinsLocalDataSourceImpl()
    }

    single<CoinsRepository> {
        CoinsRepositoryImpl(
            coinsLocalDataSource = get()
        )
    }

    single<GetCoinsUseCase> {
        GetCoinsUseCaseImpl(
            coinsRepository = get()
        )
    }
}

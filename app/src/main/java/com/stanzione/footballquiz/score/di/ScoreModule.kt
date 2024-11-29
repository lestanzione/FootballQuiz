package com.stanzione.footballquiz.score.di

import com.stanzione.footballquiz.score.data.repository.ScoreRepositoryImpl
import com.stanzione.footballquiz.score.domain.repository.ScoreRepository
import org.koin.dsl.module

val scoreModule = module {
    single<ScoreRepository> {
        ScoreRepositoryImpl()
    }
}
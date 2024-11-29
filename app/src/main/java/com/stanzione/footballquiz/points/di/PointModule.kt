package com.stanzione.footballquiz.points.di

import com.stanzione.footballquiz.points.data.repository.PointRepositoryImpl
import com.stanzione.footballquiz.points.domain.repository.PointRepository
import org.koin.dsl.module

val pointModule = module {
    single<PointRepository> {
        PointRepositoryImpl()
    }
}
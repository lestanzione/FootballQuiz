package com.stanzione.footballquiz

import android.app.Application
import com.stanzione.footballquiz.category.di.categoryModule
import com.stanzione.footballquiz.coins.di.coinsModule
import com.stanzione.footballquiz.levels.di.levelModule
import com.stanzione.footballquiz.scrambledgame.di.scrambledGameModule
import com.stanzione.footballquiz.main.di.mainModule
import com.stanzione.footballquiz.optionsgame.di.optionsGameModule
import com.stanzione.footballquiz.score.di.scoreModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(getKoinApplication(this))
    }

    private fun getKoinApplication(app: Application) = koinApplication {
        androidLogger()
        androidContext(app)
        modules(
            mainModule,
            categoryModule,
            levelModule,
            scrambledGameModule,
            optionsGameModule,
            scoreModule,
            coinsModule,
        )
    }
}

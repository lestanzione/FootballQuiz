package com.stanzione.footballquiz

import android.app.Application
import com.stanzione.footballquiz.game.di.gameModule
import com.stanzione.footballquiz.main.di.mainModule
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
            gameModule
        )
    }

}
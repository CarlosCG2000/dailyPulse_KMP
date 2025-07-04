package com.ccanogo.dailypulse.android

import android.app.Application
import com.ccanogo.dailypulse.android.di.viewModelsModule
import com.ccanogo.dailypulse.articles.data.di.sharedKoinModules
import com.ccanogo.dailypulse.android.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
class DailyPulseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule + databaseModule

        startKoin {
            androidContext(this@DailyPulseApp)
            modules(modules)
        }
    }
}
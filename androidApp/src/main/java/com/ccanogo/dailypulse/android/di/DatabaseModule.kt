package com.ccanogo.dailypulse.android.di

import app.cash.sqldelight.db.SqlDriver
import com.ccanogo.dailypulse.database.DailyPulseDatabase
import org.koin.android.ext.koin.androidContext
import com.ccanogo.dailypulse.db.DatabaseDriverFactory
import org.koin.dsl.module
val databaseModule = module {

    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }

    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}
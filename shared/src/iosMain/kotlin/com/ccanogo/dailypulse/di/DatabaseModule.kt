package com.ccanogo.dailypulse.di

import app.cash.sqldelight.db.SqlDriver
import com.ccanogo.dailypulse.database.DailyPulseDatabase
import com.ccanogo.dailypulse.db.DatabaseDriverFactory
import org.koin.dsl.module

val databaseModule = module {

    single<SqlDriver> { DatabaseDriverFactory().createDriver() }

    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}
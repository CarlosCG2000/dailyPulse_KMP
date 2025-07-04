package com.ccanogo.dailypulse.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.ccanogo.dailypulse.database.DailyPulseDatabase

actual class DatabaseDriverFactory() {

    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(
            schema = DailyPulseDatabase.Schema,
            name = "DailyPulseDatabase.db"
        )
}
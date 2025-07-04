package com.ccanogo.dailypulse.articles.data.mappers

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

fun getDaysAgoString(date: String): String {
    val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
    val days = today.daysUntil(
        Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
    )

    val result = when {
        abs(days) > 1 -> "${abs(days)} días pasados"
        abs(days) == 1 -> "Ayer"
        else -> "Hoy"
    }

    return result
}
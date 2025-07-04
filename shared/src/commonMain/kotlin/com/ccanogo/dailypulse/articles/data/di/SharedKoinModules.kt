package com.ccanogo.dailypulse.articles.data.di

// Se va a tenr que compartir entre Android y iOS
val sharedKoinModules = listOf(
    articlesModule,
    networkModule
)
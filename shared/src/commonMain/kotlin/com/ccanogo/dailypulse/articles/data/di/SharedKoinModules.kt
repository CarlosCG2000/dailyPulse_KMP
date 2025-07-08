package com.ccanogo.dailypulse.articles.data.di

// Se va a tenr que compartir entre Android y iOS
// import com.ccanogo.dailypulse.sources.di.sourcesModule

val sharedKoinModules = listOf(
    articlesModule,
    // sourceModule,
    networkModule
)
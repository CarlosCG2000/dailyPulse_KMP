package com.ccanogo.dailypulse.articles.data.di

import com.ccanogo.dailypulse.articles.data.datasource.ArticlesService
import com.ccanogo.dailypulse.articles.data.repository.ArticlesRepository
import com.ccanogo.dailypulse.articles.domain.useCases.ArticlesUseCase
import com.ccanogo.dailypulse.articles.presentation.ArticlesViewModel
import com.ccanogo.dailypulse.articles.data.datasource.ArticlesDataSource
import org.koin.dsl.module
val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }

    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
}
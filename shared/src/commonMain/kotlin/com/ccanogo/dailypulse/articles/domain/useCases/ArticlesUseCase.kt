package com.ccanogo.dailypulse.articles.domain.useCases

import com.ccanogo.dailypulse.articles.data.repository.ArticlesRepository
import com.ccanogo.dailypulse.articles.domain.model.Article
class ArticlesUseCase(private val repo: ArticlesRepository) {

//    suspend fun getArticles(forceFetch: Boolean): List<Article> {
//        val articlesRaw = repo.getArticles(forceFetch)
//        return mapArticles(articlesRaw)
//    }

    suspend fun getArticles(forceFetch: Boolean): List<Article> = repo.getArticles( forceFetch ) //.fetchArticles()
}
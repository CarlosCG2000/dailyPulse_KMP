package com.ccanogo.dailypulse.articles.data.datasource

import com.ccanogo.dailypulse.database.DailyPulseDatabase
import com.ccanogo.dailypulse.articles.domain.model.Article
import com.ccanogo.dailypulse.articles.data.entities.ArticleRaw
class ArticlesDataSource(private val database: DailyPulseDatabase?) {

    fun getAllArticles(): List<Article> =
        database?.dailyPulseDatabaseQueries?.selectAllArticles(::mapToArticle)?.executeAsList() ?: listOf()

    fun insertArticles(articles: List<Article>) {
        database?.dailyPulseDatabaseQueries?.transaction {
            articles.forEach { article ->
                insertArticle(article)
            }
        }
    }

    fun clearArticles() = database?.dailyPulseDatabaseQueries?.removeAllArticles()

    private fun insertArticle(article: Article) {
        database?.dailyPulseDatabaseQueries?.insertArticle(
            article.title, article.desc, article.date, article.imageUrl
        )
    }

    private fun mapToArticle( title: String, desc: String?, date: String, url: String? ): Article =
        Article( title, desc ?: "24/12/2000", date, imageUrl = url ?: "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png" )
}
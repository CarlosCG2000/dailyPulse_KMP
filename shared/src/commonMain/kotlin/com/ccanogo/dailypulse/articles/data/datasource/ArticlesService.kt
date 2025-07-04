package com.ccanogo.dailypulse.articles.data.datasource

import com.ccanogo.dailypulse.articles.data.entities.ArticleRaw
import com.ccanogo.dailypulse.articles.data.entities.ArticlesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient: HttpClient) {

    private val country = "us"
    private val category = "business"
    private val apiKey = "f67ace1b27b24ce4b95c7f71fde88920" // "b887b1708bdb4745902239a87a67b914"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse = httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()
        return response.articles
    }
}
package com.ccanogo.dailypulse.articles.presentation

import com.ccanogo.dailypulse.articles.domain.model.Article

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null // Lo ideal es con una clase sellada
)

package com.ccanogo.dailypulse.articles.data.mappers

import com.ccanogo.dailypulse.articles.data.entities.ArticleRaw
import com.ccanogo.dailypulse.articles.domain.model.Article

fun mapArticles(articlesRaw: List<ArticleRaw>): List<Article> = articlesRaw.map { raw ->
    Article(
        raw.title,
        raw.desc ?: "Click to find out more",
        getDaysAgoString(raw.date), // raw.date,
        raw.imageUrl
            ?: "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080"
    )
}
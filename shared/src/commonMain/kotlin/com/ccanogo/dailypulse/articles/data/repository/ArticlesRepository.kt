package com.ccanogo.dailypulse.articles.data.repository

import com.ccanogo.dailypulse.articles.data.datasource.ArticlesService
import com.ccanogo.dailypulse.articles.data.mappers.mapArticles
import com.ccanogo.dailypulse.articles.domain.model.Article

import com.ccanogo.dailypulse.articles.data.datasource.ArticlesDataSource
class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService
) {
    suspend fun getArticles(forceFetch: Boolean): List<Article> {

        if (forceFetch) dataSource.clearArticles()

         val articlesDb = dataSource.getAllArticles()

         println("Obtenidos ${articlesDb.size} de la base de datos!!")

        // Si es la primera vez que se accede o se ha limpiado la base de datos al recargarx
        if (articlesDb.isEmpty()) return fetchArticles()

        return articlesDb
    }
    suspend fun fetchArticles(): List<Article> {

        val fetchedArticles = service.fetchArticles() // OJO SI NO HAY INTERNET VA A PETAR LA APLICACIÓN TENGO QUE CONTROLAR ESTOS ERRORES

        val mappedArticles = mapArticles(fetchedArticles)

        dataSource.insertArticles(mappedArticles)

        return mappedArticles
    }
}
package com.prince.newsapp.repo

import com.prince.newsapp.BuildConfig
import com.prince.newsapp.models.Article
import com.prince.newsapp.network.NewsApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(
    private val api: NewsApiService
) {
    // In-memory cache
    private val articlesCache = mutableMapOf<String, Article>()

    // state flow for reactive updates
    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> = _articles.asStateFlow()

    private val apiKey = BuildConfig.NEWS_API_KEY

    suspend fun getTopHeadlines(
        country: String = "us",
        category: String = "business"
    ): Result<List<Article>> {

        return try {
            if (apiKey.isBlank()) throw IllegalStateException("API Key not found.")

            val response = api.getTopHeadlines(country, category, apiKey)

            val articlesList = response.articles
            val articlesWithIds = articlesList.map { article ->
                val id = article.id ?: Article.createId(article.url, article.title)
                article.copy(id = id)
            }

            // cache
            articlesWithIds.forEach { articlesCache[it.id!!] = it }
            _articles.value = articlesWithIds

            Result.success(articlesWithIds)
        }
        catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun getArticlesById(id: String): Article? = articlesCache[id]


}
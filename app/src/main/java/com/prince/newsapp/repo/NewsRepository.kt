package com.prince.newsapp.repo

import com.prince.newsapp.models.NewsResponse
import com.prince.newsapp.network.NewsApiService
import retrofit2.Response
import javax.inject.Inject
import com.prince.newsapp.BuildConfig

class NewsRepository @Inject constructor(
    private val api: NewsApiService
) {

    private val apiKey = BuildConfig.NEWS_API_KEY

    suspend fun getTopHeadlines(
        country: String = "us",
        category: String = "business"
    ): Response<NewsResponse> {

        if (apiKey.isBlank()) throw IllegalStateException("API Key not found.")
        return api.getTopHeadlines(country, category, apiKey)
    }
}
package com.prince.newsapp.network

import com.prince.newsapp.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country : String = "us",
        @Query("category") category : String = "business",
        @Query("apiKey") apiKey : String
    ): Response<NewsResponse>
}
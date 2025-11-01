package com.prince.newsapp.network

import com.prince.newsapp.models.NewsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class NewsApiService( private val client : HttpClient ) {

    suspend fun getTopHeadlines(
        country : String = "us",
        category : String = "business",
        apiKey : String
    ): NewsResponse {
        return client.get("v2/top-headlines") {
            parameter("country", country)
            parameter("category", category)
            parameter("apiKey", apiKey)
        }.body()
    }
}
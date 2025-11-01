package com.prince.newsapp.di

import com.prince.newsapp.network.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient() : HttpClient {
        // Default Engine
        return HttpClient() {

            // Base URL
            defaultRequest {
                url("https://newsapi.org/")
                contentType(ContentType.Application.Json)
            }

            // Content Negotiation for JSON serialization
            install(ContentNegotiation) {
                json()
            }

        }
    }

    @Provides
    @Singleton
    fun provideNewsApiService(client: HttpClient): NewsApiService {
        return NewsApiService(client)
    }
}
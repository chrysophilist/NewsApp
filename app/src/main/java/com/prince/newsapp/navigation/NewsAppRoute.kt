package com.prince.newsapp.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NewsAppRoute {

    @Serializable
    object HomeScreen : NewsAppRoute()

    @Serializable
    data class DetailsScreen(val articleId: String) : NewsAppRoute()
}
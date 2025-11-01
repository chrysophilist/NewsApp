package com.prince.newsapp.models

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val id: String? = null,
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String = "",
    val source: Source,
    val title: String = "",
    val url: String = "",
    val urlToImage: String? = null
) {

    companion object {
        fun createId(url: String, title: String): String {
            return "${url.hashCode()}_${title.hashCode()}".replace("-","")
        }
    }
}
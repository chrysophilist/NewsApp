package com.prince.newsapp.models

data class Article(
    val id: String?,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String?
) {

    companion object {
        fun createId(url: String, title: String): String {
            return "${url.hashCode()}_${title.hashCode()}".replace("-","")
        }
    }
}
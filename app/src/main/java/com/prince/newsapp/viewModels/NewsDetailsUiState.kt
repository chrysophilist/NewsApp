package com.prince.newsapp.viewModels

import com.prince.newsapp.models.Article

data class NewsDetailsUiState (
    val article: Article? = null,
    val isLoading: Boolean = false,
    val error: String? = null
) {
    val hasError: Boolean get() = error != null
    val hasArticle: Boolean get() = article != null
    val isEmpty: Boolean get() = !isLoading && !hasError && !hasArticle
}
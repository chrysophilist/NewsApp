package com.prince.newsapp.viewModels

import com.prince.newsapp.models.Article

sealed class NewsUiState {

    object Loading: NewsUiState()
    data class Success(val articles: List<Article>) : NewsUiState()
    data class Error(val message: String) : NewsUiState()
}
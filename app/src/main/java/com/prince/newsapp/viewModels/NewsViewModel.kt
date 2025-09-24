package com.prince.newsapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prince.newsapp.models.Article
import com.prince.newsapp.repo.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repo: NewsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<NewsUiState>(NewsUiState.Loading)
    val uiState: StateFlow<NewsUiState> = _uiState.asStateFlow()

    init {
        fetchTopHeadlines()
    }

    fun fetchTopHeadlines() {

        viewModelScope.launch {
            _uiState.value = NewsUiState.Loading

            repo.getTopHeadlines()
                .onSuccess { articles: List<Article> ->
                    _uiState.value = NewsUiState.Success(articles)
                }
                .onFailure { exception ->
                    _uiState.value = NewsUiState.Error(
                        exception.message ?: "Failed to load articles."
                    )
                }
        }
    }

    fun retry() {
        fetchTopHeadlines()
    }

}


package com.prince.newsapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prince.newsapp.repo.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailsViewModel @Inject constructor(
    private val repo: NewsRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(NewsDetailsUiState())
    val uiState: StateFlow<NewsDetailsUiState> = _uiState.asStateFlow()

    fun loadArticles(articleId: String) {
        viewModelScope.launch {

            _uiState.value = _uiState.value.copy(
                isLoading = true,
                error = null
            )

            try {
                val article = repo.getArticlesById(articleId)

                _uiState.value = if (article != null) {
                    _uiState.value.copy(
                        article = article,
                        isLoading = false,
                        error = null
                    )
                } else {
                    _uiState.value.copy(
                        isLoading = false,
                        error = "Article not found"
                    )
                }
            } catch (e:Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Failed to load article."
                )
            }
        }
    }

    fun retry(articleId: String) {
        loadArticles(articleId)
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(
            error = null
        )
    }
}


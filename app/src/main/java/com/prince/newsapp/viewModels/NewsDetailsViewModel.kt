package com.prince.newsapp.viewModels

import androidx.lifecycle.ViewModel
import com.prince.newsapp.repo.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsDetailsViewModel @Inject constructor(
    private val repo: NewsRepository
): ViewModel() {


}


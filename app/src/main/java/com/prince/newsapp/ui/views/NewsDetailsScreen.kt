package com.prince.newsapp.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil.compose.AsyncImage
import com.prince.newsapp.models.Article
import com.prince.newsapp.viewModels.NewsDetailsViewModel

@Composable
fun NewsDetailsScreen(
    articleId: String,
    onBackPressed: () -> Unit,
    viewModel: NewsDetailsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(articleId) {
        viewModel.loadArticles(articleId)
    }

    Column {
        when {
            uiState.isLoading -> {
                LoadingState()
            }
            uiState.hasError -> {
                ErrorState(
                    error = uiState.error!!,
                    onRetry = { viewModel.retry(articleId) }
                )
            }
            uiState.hasArticle -> {
                ArticlePage(
                    article = uiState.article!!,
                    modifier = modifier
                )
            }
            else -> {
                Text(text = "No article found")
            }
        }
    }
}

@Composable
fun LoadingState(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Loading...")
    }
}

@Composable
fun ErrorState(
    error: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = error)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onRetry) {
            Text(text = "Retry")
        }
    }
}

@Composable
fun ArticlePage(
    article: Article,
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            article.urlToImage?.takeIf { it.isNotEmpty() }?.let { image ->
                AsyncImage(
                    model = image,
                    contentDescription = article.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = article.title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "By ${article.author?.takeIf { it.isNotBlank() } ?: "Author name not found or unknown"}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = article.source.name.takeIf { it.isNotEmpty() } ?: "Published date not available",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = article.description?.takeIf { it.isNotEmpty() } ?: "No description available",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = article.content?.takeIf { it.isNotEmpty() } ?: "No content available",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
package com.prince.newsapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.prince.newsapp.ui.views.HomeScreen
import com.prince.newsapp.ui.views.NewsDetailsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsNavApp() {

    val navController = rememberNavController()

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("News App") }
            )
        },
        bottomBar = {},
        content = { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = NewsAppRoute.HomeScreen,
                modifier = Modifier.padding(paddingValues)
            ) {

                composable<NewsAppRoute.HomeScreen> {
                    HomeScreen(
                        onArticleClick = { articleId ->
                            navController.navigate(NewsAppRoute.DetailsScreen(articleId))
                        }
                    )
                }

                composable<NewsAppRoute.DetailsScreen> { backStackEntry ->
                    val args = backStackEntry.toRoute<NewsAppRoute.DetailsScreen>()
                    NewsDetailsScreen(
                        articleId = args.articleId,
                        onBackPressed = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    )
}
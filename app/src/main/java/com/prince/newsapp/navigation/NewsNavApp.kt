package com.prince.newsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.prince.newsapp.ui.views.HomeScreen
import com.prince.newsapp.ui.views.NewsDetailsScreen

@Composable
fun NewsNavApp() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NewsAppRoute.HomeScreen
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
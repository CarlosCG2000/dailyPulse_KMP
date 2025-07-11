package com.ccanogo.dailypulse.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ccanogo.dailypulse.android.screens.AboutScreenContent
import com.ccanogo.dailypulse.android.screens.ArticlesScreenContent
import com.ccanogo.dailypulse.android.screens.Screens
import com.ccanogo.dailypulse.articles.presentation.ArticlesViewModel
// import com.ccanogo.dailypulse.android.screens.SourcesScreen
@Composable
fun AppScaffold(/*articlesViewModel: ArticlesViewModel*/) {
    val navController = rememberNavController()

    //Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                //.padding(it),
           // articlesViewModel
        )
   // }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    // articlesViewModel: ArticlesViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLES.route,
        modifier = modifier,
    ) {
        composable(Screens.ARTICLES.route) {
            ArticlesScreenContent(
                onAboutButtonClick = { navController.navigate(Screens.ABOUT_DEVICE.route) },
                // articlesViewModel,
            )
        }

        /**composable(Screens.SOURCES.route) {
            SourcesScreen(
                onUpButtonClick = { navController.popBackStack() }
            )
        }*/

        composable(Screens.ABOUT_DEVICE.route) {
            AboutScreenContent (
                onAboutButtonClick = { navController.popBackStack() }
            )
        }
    }
}
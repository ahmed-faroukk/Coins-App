package com.farouk.compose_mvvm_cleanarch.presentation.components

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.farouk.compose_mvvm_cleanarch.presentation.coindetails.CoinDetailScreen
import com.farouk.compose_mvvm_cleanarch.presentation.coinlist.CoinListScreen


@ExperimentalLayoutApi
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenRoutes.CoinsListScreen.route) {
        composable(route = ScreenRoutes.CoinsListScreen.route) { CoinListScreen(navController) }
        composable(route = ScreenRoutes.CoinsDetailScreen.route + "/{coinId}" ) { CoinDetailScreen() }
    }
}
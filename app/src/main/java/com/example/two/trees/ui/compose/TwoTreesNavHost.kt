package com.example.two.trees.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.two.trees.MainViewModel

@Composable
fun TwoTreesNavHost(
    navController: NavHostController,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val products by viewModel.products.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                takeTourClick = {
                    navController.navigate(Screen.Tours.route)
                }
            )
        }
        composable(route = Screen.Tours.route) {
            ToursScreen()
        }
        composable(route = Screen.Shop.route) {
            ShopScreen(products = products)
        }
    }
}

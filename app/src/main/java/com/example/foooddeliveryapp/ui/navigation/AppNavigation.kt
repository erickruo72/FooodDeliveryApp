package com.example.foooddeliveryapp.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foooddeliveryapp.ui.screens.HomeScreen
import com.example.foooddeliveryapp.ui.screens.DetailScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        // Transition to Home Screen
        composable("home") {
            HomeScreen(
                onRestaurantClick = { navController.navigate("detail") }
            )
        }

        // Transition to Restaurant Details
        composable("detail") {
            DetailScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}
package com.example.giftvault.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.giftvault.screens.authentication.AuthenticateScreen
import com.example.giftvault.screens.HomeScreen
import com.example.giftvault.screens.authentication.LoginScreen
import com.example.giftvault.screens.authentication.SignupScreen

@Composable
fun GiftVaultNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = GiftVaultScreens.LoginScreen.name
    ) {

        composable(GiftVaultScreens.LoginScreen.name) {
            LoginScreen(
                navController = navController
            )
        }

        composable(GiftVaultScreens.SignupScreen.name) {
            SignupScreen(
                navController = navController
            )
        }

        composable(
            route = GiftVaultScreens.HomeScreen.name + "/{userId}",
            arguments = listOf(navArgument("userId") { type = NavType.StringType })
        ) { backStackEntry ->
            // Assuming the userId should be parsed as an Int; adjust based on your data model
            val userId = backStackEntry.arguments?.getString("userId")?.toIntOrNull()
            if (userId != null) {
                HomeScreen(navController = navController, userId = userId)
            } else {
                // Handle error: No user ID passed or conversion failed
            }
        }
    }
}
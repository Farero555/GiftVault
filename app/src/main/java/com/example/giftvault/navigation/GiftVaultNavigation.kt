package com.example.giftvault.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.giftvault.screens.LoginScreen

@Composable
fun GiftVaultNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination =  GiftVaultScreens.LoginScreen.name) {

        composable(GiftVaultScreens.LoginScreen.name){
            LoginScreen(navController = navController)
        }

//        composable(MovieScreens.DetailsScreen.name + "/{movie}",
//            arguments = listOf(navArgument(name = "movie"){type = NavType.StringType})) {
//                backStackEntry ->
//
//            DetailsScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
//        }
    }
}
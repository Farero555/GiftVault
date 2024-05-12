package com.example.giftvault.navigation

enum class GiftVaultScreens {
    LoginScreen, HomeScreen;
    companion object{
        fun fromRoute(route: String?): GiftVaultScreens
        = when (route?.substringBefore("/")){
            LoginScreen.name -> LoginScreen
            HomeScreen.name -> HomeScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }

}
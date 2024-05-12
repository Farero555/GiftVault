package com.example.giftvault.navigation

enum class GiftVaultScreens {
    AuthenticationScreen, LoginScreen, SignupScreen, HomeScreen;
    companion object{
        fun fromRoute(route: String?): GiftVaultScreens
        = when (route?.substringBefore("/")){
            AuthenticationScreen.name -> AuthenticationScreen
            LoginScreen.name -> LoginScreen
            SignupScreen.name -> SignupScreen
            HomeScreen.name -> HomeScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }

}
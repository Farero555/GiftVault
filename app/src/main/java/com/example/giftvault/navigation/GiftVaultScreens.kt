package com.example.giftvault.navigation

enum class GiftVaultScreens {
    LoginScreen;
    companion object{
        fun fromRoute(route: String?): GiftVaultScreens
        = when (route?.substringBefore("/")){
            LoginScreen.name -> LoginScreen
            null -> LoginScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }

}
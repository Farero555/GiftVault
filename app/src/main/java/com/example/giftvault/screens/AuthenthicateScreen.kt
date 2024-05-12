package com.example.giftvault.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.giftvault.components.GVButton
import com.example.giftvault.navigation.GiftVaultScreens

@Composable
fun AuthenticateScreen(navController: NavController){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GVButton(modifier = Modifier.fillMaxWidth(), text = "Log In", onClick = { handleSimpleRedirect(navController, GiftVaultScreens.LoginScreen) })
            GVButton(modifier = Modifier.fillMaxWidth(), text = "Sign Up", onClick = { handleSimpleRedirect(navController, GiftVaultScreens.SignupScreen) })
        }
    }
}

fun handleSimpleRedirect(navController: NavController, redirectScreen: GiftVaultScreens) {
    navController.navigate(route = redirectScreen.name)
}

package com.example.giftvault.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.giftvault.components.GVButton
import com.example.giftvault.components.GiftVaultInputText
import com.example.giftvault.navigation.GiftVaultScreens

@Composable
fun LoginScreen(navController: NavController){
    var usernameInput by remember {
        mutableStateOf("")
    }
    var passwordInput by remember {
        mutableStateOf("")
    }

    Column {
        GiftVaultInputText(text = usernameInput, label = "Enter username", onTextChange = {usernameInput = it});
        GiftVaultInputText(text = passwordInput, label = "Enter password", onTextChange = {passwordInput = it});
        GVButton(text = "Log In", onClick = { navController.navigate(route = GiftVaultScreens.HomeScreen.name) });
    }
}

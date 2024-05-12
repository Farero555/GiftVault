package com.example.giftvault.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Greetings!")
            GiftVaultInputText(text = usernameInput, label = "Enter username", onTextChange = { usernameInput = it })
            GiftVaultInputText(text = passwordInput, label = "Enter password", onTextChange = { passwordInput = it })
            Spacer(modifier = Modifier.height(16.dp))
            GVButton(text = "Log In", onClick = { navController.navigate(route = GiftVaultScreens.HomeScreen.name) })
        }
    }
}

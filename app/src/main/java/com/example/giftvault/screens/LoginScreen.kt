package com.example.giftvault.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.giftvault.components.GVButton
import com.example.giftvault.components.GiftVaultInputText
import com.example.giftvault.mockdata.Users
import com.example.giftvault.model.User
import com.example.giftvault.navigation.GiftVaultScreens
import com.example.giftvault.ui.theme.TimberWolf

@Composable
fun LoginScreen(navController: NavController){
    var usernameInput by remember {
        mutableStateOf("")
    }
    var passwordInput by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(TimberWolf),
        contentAlignment = Alignment.Center,

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text("Greetings!")
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    GiftVaultInputText(
                        modifier = Modifier.padding(top = 16.dp),
                        text = usernameInput,
                        label = "Enter username",
                        onTextChange = { usernameInput = it },)
                    Spacer(modifier = Modifier.height(8.dp))
                    GiftVaultInputText(
                        modifier = Modifier.padding(bottom = 16.dp),
                        text = passwordInput,
                        label = "Enter password",
                        onTextChange = { passwordInput = it })

                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            GVButton(text = "Log In", onClick = { handleLogin(usernameInput, navController) })
        }
    }
}

fun handleLogin(username: String, navController: NavController ) {
    val user: User? = Users.userList.find { it.username == username }
    if (user != null) {
        val userIndex = Users.userList.indexOf(user).toString()  // Convert index to string
        navController.navigate(route = GiftVaultScreens.HomeScreen.name + "/$userIndex")
    }
}

package com.example.giftvault.screens.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.giftvault.R
import com.example.giftvault.components.GVButton
import com.example.giftvault.components.GiftVaultInputText
import com.example.giftvault.mockdata.Users
import com.example.giftvault.model.User
import com.example.giftvault.navigation.GiftVaultScreens

@Composable
fun LoginScreen(navController: NavController){

    var usernameInput by remember {
        mutableStateOf("")
    }
    var passwordInput by remember {
        mutableStateOf("")
    }
    var rememberMe by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFC7CE01), // Yellow
                        Color(0xFFFAC311), // Orange
                    )
                )
            ),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 30.dp),
            painter = painterResource(id = R.drawable.giftvault_logo_transperent),
            contentDescription = ""
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            colors = CardDefaults.cardColors(
                containerColor = if(isSystemInDarkTheme()) Color(0xFF121212) else Color.White

            ),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    color = if(!isSystemInDarkTheme()) Color(0xFF121212) else Color.White,
                    modifier = Modifier.padding(top = 16.dp),
                    text = "Welcome To GiftVault!",
                    fontSize = 24.sp,
                    fontFamily = FontFamily.SansSerif
                )
                Spacer(modifier = Modifier.height(10.dp))

                GiftVaultInputText(
                    modifier = Modifier.padding(top = 12.dp),
                    text = usernameInput,
                    label = "Enter username",
                    onTextChange = { usernameInput = it }

                )
                Spacer(modifier = Modifier.height(8.dp))

                GiftVaultInputText(
                    modifier = Modifier.padding(bottom = 4.dp),
                    text = passwordInput,
                    label = "Enter password",
                    onTextChange = { passwordInput = it },
                    visualTransformation = PasswordVisualTransformation('•')
                )
                Row(
                    modifier = Modifier
                        .offset(x = (-70).dp)
                        .padding(bottom = 14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = rememberMe,
                        onCheckedChange = { rememberMe = it }
                    )
                    Text(
                        color = if(!isSystemInDarkTheme()) Color(0xFF121212) else Color.White,
                        text = "Remember Me",
                        fontSize = 14.sp
                    )
                }
                GVButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 54.dp, vertical = 1.dp),
                    text = "Log In",
                    onClick = { handleLogin(usernameInput, navController) }
                )
                GVButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 54.dp, vertical = 1.dp),
                    text = "Sign Up",
                    onClick = { navController.navigate(route = GiftVaultScreens.SignupScreen.name) }
                )
            }
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

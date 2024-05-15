package com.example.giftvault.screens.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.giftvault.components.GVButton
import com.example.giftvault.components.GiftVaultInputText
import com.example.giftvault.mockdata.Users
import com.example.giftvault.model.User
import com.example.giftvault.navigation.GiftVaultScreens
import com.example.giftvault.ui.theme.PrimaryColor

@Composable
fun SignupScreen(navController: NavController){
    var firstNameInput by remember {
        mutableStateOf("")
    }
    var lastNameInput by remember {
        mutableStateOf("")
    }
    var emailInput by remember {
        mutableStateOf("")
    }
    var usernameInput by remember {
        mutableStateOf("")
    }
    var passwordInput by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .navigationBarsPadding()
    ) {

        IconButton(
            onClick = { navController.navigate(route = GiftVaultScreens.LoginScreen.name)},
            modifier = Modifier.align(Alignment.TopStart).padding(start = 16.dp, end = 16.dp, top = 32.dp)
            ){
            Icon(
                modifier = Modifier.size(60.dp),
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = PrimaryColor
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                color = if(!isSystemInDarkTheme()) Color(0xFF121212) else Color.White,
                text = "Sign Up To Get Started!",
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(12.dp))

            GiftVaultInputText(text = firstNameInput, label = "Enter first name", onTextChange = { firstNameInput = it })
            GiftVaultInputText(text = lastNameInput, label = "Enter last name", onTextChange = { lastNameInput = it })
            GiftVaultInputText(text = emailInput, label = "Enter email", onTextChange = { emailInput = it })
            GiftVaultInputText(text = usernameInput, label = "Enter username", onTextChange = { usernameInput = it })
            GiftVaultInputText(text = passwordInput, label = "Enter password", onTextChange = { passwordInput = it }, visualTransformation = PasswordVisualTransformation('•'))
            GiftVaultInputText(text = confirmPassword, label = "Confirm password", onTextChange = { confirmPassword = it }, visualTransformation = PasswordVisualTransformation('•'))

            Spacer(modifier = Modifier.height(16.dp))
            GVButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 38.dp),
                text = "Sign Up",
                onClick = { handleSignup(firstNameInput, lastNameInput, emailInput, usernameInput, passwordInput, navController) }
            )
        }
    }
}

fun handleSignup(
    firstName: String,
    lastName: String,
    email: String,
    username: String,
    password: String,
    navController: NavController
) {
    val user: User = User(firstName, lastName, email, username, password);
    if (Users.userList.add(user)) {
        val userIndex = Users.userList.indexOf(user).toString()
        navController.navigate(route = GiftVaultScreens.HomeScreen.name + "/$userIndex")
    }
}

package com.example.giftvault.screens.authentication

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
import com.example.giftvault.mockdata.Users
import com.example.giftvault.model.User
import com.example.giftvault.navigation.GiftVaultScreens

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

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Greetings!")
            GiftVaultInputText(text = firstNameInput, label = "Enter first name", onTextChange = { firstNameInput = it })
            GiftVaultInputText(text = lastNameInput, label = "Enter last name", onTextChange = { lastNameInput = it })
            GiftVaultInputText(text = emailInput, label = "Enter email", onTextChange = { emailInput = it })
            GiftVaultInputText(text = usernameInput, label = "Enter username", onTextChange = { usernameInput = it })
            GiftVaultInputText(text = passwordInput, label = "Enter password", onTextChange = { passwordInput = it })
            Spacer(modifier = Modifier.height(16.dp))
            GVButton(text = "Sign Up", onClick = { handleSignup(firstNameInput, lastNameInput, emailInput, usernameInput, passwordInput, navController) })
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

package com.example.giftvault.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.giftvault.mockdata.Users

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, userId: Int){
    TopAppBar(
        title = {
            Text("Hi, ${Users.userList[userId].firstName}")
        }
    )
}

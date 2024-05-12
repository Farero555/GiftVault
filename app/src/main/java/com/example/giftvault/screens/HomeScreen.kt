package com.example.giftvault.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    TopAppBar(
        modifier = ,
        title = {

            Text("GiftVault")
        }
    )
}

@Preview
@Composable
fun PrevComponent(){
    HomeScreen()
}
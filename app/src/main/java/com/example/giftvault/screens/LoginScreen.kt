package com.example.giftvault.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.giftvault.components.NoteButton

@Composable
fun LoginScreen(
//    navController: NavController
){

    var text by remember{
        mutableStateOf("Press")
    }

    NoteButton(
        text = text,
        onClick = {
            text = "You pressed button!!"
    })
}

@Preview()
@Composable
fun PreviewComponent(){
    LoginScreen()
}


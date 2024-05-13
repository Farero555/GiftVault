package com.example.giftvault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.example.giftvault.mockdata.Users
import com.example.giftvault.navigation.GiftVaultNavigation
import com.example.giftvault.ui.theme.GiftVaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                android.graphics.Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        Users.initUsers()
        setContent {
            GiftVaultApp{
                GiftVaultNavigation()
            }
        }
    }
}

@Composable
fun GiftVaultApp(content: @Composable () -> Unit){
    GiftVaultTheme {
        content()
    }
}
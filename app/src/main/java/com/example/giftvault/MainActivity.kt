package com.example.giftvault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.giftvault.navigation.GiftVaultNavigation
import com.example.giftvault.ui.theme.GiftVaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
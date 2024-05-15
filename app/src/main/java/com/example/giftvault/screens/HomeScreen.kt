package com.example.giftvault.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemGesturesPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.giftvault.R
import com.example.giftvault.ui.theme.PrimaryColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, userId: Int) {
    Scaffold(
        bottomBar = {
            Column(modifier = Modifier.navigationBarsPadding()) {
                Divider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    thickness = 4.dp,
                    color = PrimaryColor,

                )
                BottomAppBar(
                    containerColor = Color.Transparent
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(horizontal = 16.dp),
                    ){
                        IconButton(
                            onClick = {}
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                                Icon(
                                    modifier = Modifier.size(38.dp),
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "Friends"
                                )
                                Text(
                                    fontSize = 12.sp,
                                    text = "Friends"
                                )
                            }
                        }
                        IconButton(
                            onClick = {}) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                                Icon(
                                    modifier = Modifier.size(38.dp),
                                    painter = painterResource(id = R.drawable.baseline_groups_24),
                                    contentDescription = "Groups"
                                )
                                Text(
                                    fontSize = 12.sp,
                                    text = "Groups"
                                )
                            }

                        }
                    }
                }
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {

        }
    }
}
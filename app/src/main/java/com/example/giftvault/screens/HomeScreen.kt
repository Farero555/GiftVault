package com.example.giftvault.screens

import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.giftvault.R
import com.example.giftvault.ui.theme.MetallicBronze
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, userId: Int) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    fun toggleDrawer() {
        coroutineScope.launch {
            if (drawerState.isClosed) {
                drawerState.open()
            } else {
                drawerState.close()
            }
        }
    }

    ModalNavigationDrawer(
        modifier = Modifier,
        drawerState = drawerState,
        drawerContent = {
            DrawerContent()
        }
    ) {
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                CenterAlignedTopAppBar(
                    modifier = Modifier,
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MetallicBronze,
                        titleContentColor = Color.White
                    ),
                    title = {
                        Text("Home")
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = { toggleDrawer() },
                            colors = IconButtonDefaults.filledIconButtonColors(
                                contentColor = Color.White
                            )

                        ) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Menu"
                            )

                        }
                    },
                    actions = {
                        IconButton(
                            onClick = { /* Handle other actions here */ },
                            colors = IconButtonDefaults.filledIconButtonColors(
                                contentColor = Color.White
                            )

                        ) {
                            Icon(
                                imageVector = Icons.Filled.AccountCircle,
                                contentDescription = "Profile"
                            )
                        }
                    }
                )
            }
        ) {
            Column(modifier = Modifier.padding(it)) {

            }
        }
    }
}

@Composable
fun DrawerContent() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Drawer Item 1")
        Text("Drawer Item 2")
    }
}

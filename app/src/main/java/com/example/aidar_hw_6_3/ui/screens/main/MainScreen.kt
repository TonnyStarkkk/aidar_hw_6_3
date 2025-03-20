package com.example.aidar_hw_6_3.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.aidar_hw_6_3.ui.components.BottomNavigationBar
import com.example.aidar_hw_6_3.ui.components.TopAppBar
import com.example.aidar_hw_6_3.ui.navigation.NavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(navController)
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        NavGraph(
            modifier = Modifier
                .padding(innerPadding),
            navController = navController
        )
    }
}

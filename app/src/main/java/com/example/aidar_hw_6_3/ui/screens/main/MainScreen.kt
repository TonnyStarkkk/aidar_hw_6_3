package com.example.aidar_hw_6_3.ui.screens.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.aidar_hw_6_3.ui.components.BottomNavigationBar
import com.example.aidar_hw_6_3.ui.components.TopAppBar
import com.example.aidar_hw_6_3.ui.navigation.NavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val listState = rememberLazyListState()

    val isBottomBarVisible by remember {
        derivedStateOf {
            val firstVisibleItemIndex = listState.firstVisibleItemIndex
            val firstVisibleItemScrollOffset = listState.firstVisibleItemScrollOffset
            firstVisibleItemIndex == 0 && firstVisibleItemScrollOffset <= 0
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(navController)
        },
        bottomBar = {
            AnimatedVisibility(
                visible = isBottomBarVisible
            ) {
                BottomNavigationBar(navController)
            }
        }
    ) { innerPadding ->
        NavGraph(
            modifier = Modifier
                .padding(innerPadding),
            navController = navController,
            listState = listState
        )
    }
}

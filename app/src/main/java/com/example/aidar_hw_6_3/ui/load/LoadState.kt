package com.example.aidar_hw_6_3.ui.load

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState

@Composable
fun LoadState(
    loadState: CombinedLoadStates,
    onRetry: () -> Unit
) {
    when (loadState.refresh) {
        is LoadState.Loading -> {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Loading..."
                )
            }
        }
        is LoadState.Error -> {
            val error = (loadState.refresh as LoadState.Error).error
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Error: ${error.localizedMessage}"
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = onRetry
                ) {
                    Text(
                        text = "Retry"
                    )
                }
            }
        }
        else -> {}
    }
}
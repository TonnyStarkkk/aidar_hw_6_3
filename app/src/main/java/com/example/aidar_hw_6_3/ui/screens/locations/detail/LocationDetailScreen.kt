package com.example.aidar_hw_6_3.ui.screens.locations.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.example.aidar_hw_6_3.ui.models.Location
import kotlinx.serialization.json.Json

@Composable
fun LocationDetailScreen(location: Location) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Name: ${location.name}",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Type: ${location.type}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Dimension: ${location.dimension}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
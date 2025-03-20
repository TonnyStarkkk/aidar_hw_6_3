package com.example.aidar_hw_6_3.ui.screens.locations.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.example.aidar_hw_6_3.ui.models.Location
import kotlinx.serialization.json.Json

@Composable
fun LocationDetailScreen(location: Location) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = "Name: ${location.name}",
            style = MaterialTheme.typography.bodyLarge
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
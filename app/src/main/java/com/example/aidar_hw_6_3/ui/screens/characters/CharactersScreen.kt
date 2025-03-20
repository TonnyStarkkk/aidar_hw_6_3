package com.example.aidar_hw_6_3.ui.screens.characters

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.aidar_hw_6_3.data.MockData
import com.example.aidar_hw_6_3.ui.models.Character
import com.example.aidar_hw_6_3.ui.navigation.Screen

@Composable
fun CharactersScreen(navController: NavController) {
    Column {
        LazyColumn {
            items(MockData.characters) { character ->
                CharacterItem(character, navController)
            }
        }
    }
}

@Composable
fun CharacterItem(character: Character, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                val route = Screen.CharacterDetail.createRoute(character)
                navController.navigate(route)
            }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            painter = rememberAsyncImagePainter(character.image),
            contentDescription = character.name,
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = character.name,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = character.status,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
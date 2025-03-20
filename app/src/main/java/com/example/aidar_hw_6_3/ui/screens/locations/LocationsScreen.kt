import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aidar_hw_6_3.data.MockData
import com.example.aidar_hw_6_3.ui.models.Location
import com.example.aidar_hw_6_3.ui.navigation.Screen

@Composable
fun LocationsScreen(navController: NavController) {
    Column {
        LazyColumn {
            items(MockData.locations) { location ->
                LocationItem(location, navController)
            }
        }
    }
}

@Composable
fun LocationItem(location: Location, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                val route = Screen.LocationDetail.createRoute(location)
                navController.navigate(route)
            }
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = location.name,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Type: ${location.type}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aidar_hw_6_3.data.dto.location.LocationDTO
import com.example.aidar_hw_6_3.ui.screens.locations.LocationsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun LocationsScreen(
    navController: NavController,
    viewModel: LocationsViewModel = koinViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.fetchAllLocations()
    }

    val locations = viewModel.locationsStateFlow.collectAsState()

    Column {
        LazyColumn {
            items(
                items = locations.value
            ) { location ->
                LocationItem(location) {
                    navController.navigate("locationDetail/${location.id}")
                }
            }
        }
    }
}

@Composable
fun LocationItem(location: LocationDTO, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(
                onClick = onClick
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = location.name!!,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = location.type!!,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.aidar_hw_6_3.data.dto.location.LocationDTO
import com.example.aidar_hw_6_3.ui.components.LoadState
import com.example.aidar_hw_6_3.ui.screens.locations.LocationsViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationsScreen(
    navController: NavController,
    viewModel: LocationsViewModel = koinViewModel(),
    listState: LazyListState
) {

    LaunchedEffect(Unit) {
        viewModel.fetchAllLocations()
    }

    val isRefreshing = viewModel.isRefreshing.collectAsState()
    val locations = viewModel.locationsStateFlow.collectAsLazyPagingItems()

    PullToRefreshBox(
        isRefreshing = isRefreshing.value,
        onRefresh = {
            viewModel.refreshLocations()
        }
    ) {
        LoadState(
            loadState = locations.loadState,
            onRetry = {
                locations.retry()
            }
        )

        Column {
            LazyColumn(
                state = listState
            ) {
                items(
                    count = locations.itemCount
                ) { index ->
                    val location = locations[index]
                    location?.let {
                        LocationItem(location) {
                            navController.navigate("locationDetail/${location.id}")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LocationItem(
    location: LocationDTO,
    onClick: () -> Unit
) {

    var isPressed by remember { mutableStateOf(false) }
    val locationHeight by animateDpAsState(
        targetValue = if (isPressed) 100.dp else 80.dp
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(locationHeight)
            .padding(16.dp)
            .clickable(
                onClick = {
                    isPressed = !isPressed
                    onClick()
                }
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
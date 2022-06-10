package fr.ippon.trame.explore.location

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.ippon.trame.shared.favorite.FavoriteListItem
import fr.ippon.trame.shared.theme.TheRickAndMortyEncyclopediaTheme

@Composable
fun LocationsList(
    data: LocationsListData,
    modifier: Modifier = Modifier,
    onClick: (LocationsListItemData) -> Unit = {},
    onFavoriteChanged: (LocationsListItemData, Boolean) -> Unit = { _, _ -> }
) {
    LazyColumn(modifier = modifier) {
        items(items = data.locations, key = { item -> item.id }) { item ->
            LocationsListItem(item, onClick, onFavoriteChanged)
        }
    }
}

@Composable
private fun LocationsListItem(
    data: LocationsListItemData,
    onClick: (LocationsListItemData) -> Unit,
    onFavoriteChanged: (LocationsListItemData, Boolean) -> Unit
) {
    FavoriteListItem(
        favorite = data.favorite,
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .clickable { onClick(data) },
        onChange = { favorite -> onFavoriteChanged(data, favorite) }
    ) {
        Text(
            text = data.name,
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
@Preview
private fun PreviewLocationsList() {
    TheRickAndMortyEncyclopediaTheme {
        LocationsList(
            data = LocationsListData(
                locations = listOf(
                    LocationsListItemData(
                        id = "1",
                        name = "Earth (C-137)",
                    ),
                    LocationsListItemData(
                        id = "1",
                        name = "Earth (C-999)",
                    ),
                    LocationsListItemData(
                        id = "1",
                        name = "Earth (C-654)",
                    ),
                ),
            ), modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
@Preview
private fun PreviewLocationsListItem() {
    TheRickAndMortyEncyclopediaTheme {
        LocationsListItem(
            data = LocationsListItemData(
                id = "1",
                name = "Earth (C-137)",
            ),
            onFavoriteChanged = { _, _ -> },
            onClick = {}
        )
    }
}

data class LocationsListData(val locations: List<LocationsListItemData>)

data class LocationsListItemData(
    val id: String,
    val name: String,
    val favorite: Boolean = false
)
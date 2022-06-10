package fr.ippon.trame.explore.episode

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
fun EpisodesList(
    data: EpisodesListData,
    modifier: Modifier = Modifier,
    onClick: (EpisodesListItemData) -> Unit = {},
    onFavoriteChanged: (EpisodesListItemData, Boolean) -> Unit = { _, _ -> }
) {
    LazyColumn(modifier = modifier) {
        items(items = data.episodes, key = { item -> item.id }) { item ->
            EpisodesListItem(item, onClick, onFavoriteChanged)
        }
    }
}

@Composable
private fun EpisodesListItem(
    data: EpisodesListItemData,
    onClick: (EpisodesListItemData) -> Unit,
    onFavoriteChanged: (EpisodesListItemData, Boolean) -> Unit
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
private fun PreviewEpisodesList() {
    TheRickAndMortyEncyclopediaTheme {
        EpisodesList(
            data = EpisodesListData(
                episodes = listOf(
                    EpisodesListItemData(
                        id = "1",
                        name = "S01E01 — Pilot",
                    ),
                    EpisodesListItemData(
                        id = "2",
                        name = "S01E02 — The Awakening",
                    ),
                    EpisodesListItemData(
                        id = "3",
                        name = "S01E03 — The End",
                    ),
                ),
            ), modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
@Preview
private fun PreviewEpisodesListItem() {
    TheRickAndMortyEncyclopediaTheme {
        EpisodesListItem(
            data = EpisodesListItemData(
                id = "1",
                name = "S01E01 — Pilot",
            ),
            onFavoriteChanged = { _, _ -> },
            onClick = {}
        )
    }
}

data class EpisodesListData(val episodes: List<EpisodesListItemData>)

data class EpisodesListItemData(
    val id: String,
    val name: String,
    val favorite: Boolean = false
)
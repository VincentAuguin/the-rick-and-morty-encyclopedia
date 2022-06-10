package fr.ippon.trame.explore.character

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import fr.ippon.trame.R
import fr.ippon.trame.shared.favorite.FavoriteListItem
import fr.ippon.trame.shared.theme.TheRickAndMortyEncyclopediaTheme

@Composable
fun CharactersList(
    data: CharactersListData,
    modifier: Modifier = Modifier,
    onClick: (CharactersListItemData) -> Unit = {},
    onFavoriteChanged: (CharactersListItemData, Boolean) -> Unit = { _, _ -> }
) {
    LazyColumn(modifier = modifier) {
        items(items = data.characters, key = { item -> item.id }) { item ->
            CharactersListItem(item, onClick, onFavoriteChanged)
        }
    }
}

@Composable
private fun CharactersListItem(
    data: CharactersListItemData,
    onClick: (CharactersListItemData) -> Unit,
    onFavoriteChanged: (CharactersListItemData, Boolean) -> Unit
) {
    FavoriteListItem(
        favorite = data.favorite,
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .clickable { onClick(data) },
        onChange = { favorite -> onFavoriteChanged(data, favorite) }
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data.imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            placeholder = painterResource(
                id = R.drawable.rick_and_morty_through_portal
            ),
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = data.name,
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
@Preview
private fun PreviewCharactersList() {
    TheRickAndMortyEncyclopediaTheme {
        CharactersList(
            data = CharactersListData(
                characters = listOf(
                    CharactersListItemData(
                        id = "1",
                        name = "Rick",
                    ),
                    CharactersListItemData(
                        id = "2",
                        name = "Morty",
                    ),
                    CharactersListItemData(
                        id = "3",
                        name = "Summer"
                    ),
                    CharactersListItemData(
                        id = "3",
                        name = "Jerry"
                    ),
                    CharactersListItemData(
                        id = "4",
                        name = "Beth"
                    )
                ),
            ), modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
@Preview
private fun PreviewCharactersListItem() {
    TheRickAndMortyEncyclopediaTheme {
        CharactersListItem(
            data = CharactersListItemData(
                id = "1",
                name = "Rick",
            ),
            onFavoriteChanged = { _, _ -> },
            onClick = {}
        )
    }
}

data class CharactersListData(val characters: List<CharactersListItemData>)

data class CharactersListItemData(
    val id: String,
    val name: String,
    val imageUrl: String? = null,
    val favorite: Boolean = false
)
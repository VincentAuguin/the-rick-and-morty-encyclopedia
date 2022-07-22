package com.deezer.rickandmorty.character

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

data class CharacterListItemData(
    val id: String,
    val name: String,
    val image: String
)

@Composable
fun CharacterList(characters: List<CharacterListItemData>) {
    LazyColumn {
        items(characters, key = { item -> item.id }) { item ->
            CharacterListItem(data = item)
        }
    }
}

@Composable
private fun CharacterListItem(data: CharacterListItemData) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = data.name)
    }
}

@Composable
@Preview
private fun PreviewCharacterListItem() {
    Surface(modifier = Modifier.background(MaterialTheme.colors.background)) {
        CharacterListItem(
            data = CharacterListItemData(
                id = "1",
                name = "Rick",
                image = ""
            )
        )
    }
}
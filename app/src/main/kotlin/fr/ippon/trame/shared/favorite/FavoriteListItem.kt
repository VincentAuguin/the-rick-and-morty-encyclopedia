package fr.ippon.trame.shared.favorite

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.ippon.trame.shared.theme.Red600

@Composable
fun FavoriteListItem(
    favorite: Boolean,
    modifier: Modifier = Modifier,
    onChange: (Boolean) -> Unit,
    content: @Composable RowScope.() -> Unit,
) {
    val state = remember { mutableStateOf(favorite) }
    Box(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 12.dp)
            ) {
                content()
            }
            IconButton(onClick = {
                state.value = !state.value
                onChange(state.value)
            }) {
                Icon(
                    imageVector = if (state.value) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    tint = Red600
                )
            }
        }
    }
}
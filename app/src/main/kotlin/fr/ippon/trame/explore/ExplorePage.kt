package fr.ippon.trame.explore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import fr.ippon.trame.R
import fr.ippon.trame.explore.character.CharactersList
import fr.ippon.trame.explore.character.ExploreCharactersViewModel
import fr.ippon.trame.explore.episode.EpisodesList
import fr.ippon.trame.explore.episode.ExploreEpisodesViewModel
import fr.ippon.trame.explore.location.ExploreLocationsViewModel
import fr.ippon.trame.explore.location.LocationsList
import fr.ippon.trame.shared.theme.TheRickAndMortyEncyclopediaTheme

@Composable
fun ExplorePage(navController: NavController) {
    val viewModel = viewModel<ExploreViewModel>()
    val favoriteOnly = viewModel.displayOnlyFavorite.collectAsState()

    Scaffold(
        topBar = { ExplorePageTopBar(favoriteOnly.value) { viewModel.toggleFavoriteDisplay() } }
    ) { paddingValues ->
        RefreshDataEffect()
        ExplorePageTabs(navController = navController, modifier = Modifier.padding(paddingValues))
    }
}

@Composable
private fun ExplorePageTopBar(favoriteOnly: Boolean, onFavoriteClicked: () -> Unit) {
    TopAppBar(title = {
        Text(
            text = stringResource(id = R.string.explore_text_top_bar),
            style = MaterialTheme.typography.h1
        )
    },
        actions = {
            IconButton(onClick = onFavoriteClicked) {
                Icon(
                    imageVector = if (favoriteOnly) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
private fun RefreshDataEffect() {
    val viewModel = viewModel<ExploreViewModel>()

    LaunchedEffect(key1 = Unit) {
        viewModel.refreshData()
    }
}

@Composable
private fun ExplorePageTabs(navController: NavController, modifier: Modifier = Modifier) {
    Column {
        val state = remember { mutableStateOf(ExplorePageTab.CHARACTERS) }
        TabRow(
            selectedTabIndex = state.value.ordinal,
            backgroundColor = MaterialTheme.colors.primaryVariant,
            modifier = modifier
        ) {
            ExplorePageTab(state, ExplorePageTab.CHARACTERS)
            ExplorePageTab(state, ExplorePageTab.EPISODES)
            ExplorePageTab(state, ExplorePageTab.LOCATIONS)
        }

        when (state.value) {
            ExplorePageTab.CHARACTERS -> ExplorePageTabCharactersContent(navController)
            ExplorePageTab.EPISODES -> ExplorePageTabEpisodesContent(navController)
            ExplorePageTab.LOCATIONS -> ExplorePageTabLocationsContent(navController)
        }
    }
}

@Composable
private fun ExplorePageTab(
    state: MutableState<ExplorePageTab>,
    tab: ExplorePageTab,
) {
    Tab(
        selected = state.value == tab,
        text = {
            Text(
                text = stringResource(id = tab.title).toUpperCase(Locale.current),
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        },
        onClick = { state.value = tab }
    )
}

@Composable
private fun ExplorePageTabCharactersContent(navController: NavController) {
    val viewModel = viewModel<ExploreCharactersViewModel>()
    val data by viewModel.getCharacters(viewModel<ExploreViewModel>().displayOnlyFavorite)
        .collectAsState()

    CharactersList(
        data = data,
        modifier = Modifier.fillMaxSize(),
        onFavoriteChanged = { item, favorite -> viewModel.setFavorite(item.id, favorite) },
        onClick = { item ->
            navController.navigate("/characters/${item.id}")
        })
}

@Composable
private fun ExplorePageTabEpisodesContent(navController: NavController) {
    val viewModel = viewModel<ExploreEpisodesViewModel>()
    val data by viewModel.getEpisodes(viewModel<ExploreViewModel>().displayOnlyFavorite)
        .collectAsState()

    EpisodesList(
        data = data,
        modifier = Modifier.fillMaxSize(),
        onFavoriteChanged = { item, favorite -> viewModel.setFavorite(item.id, favorite) },
        onClick = { item ->
            navController.navigate("/episodes/${item.id}")
        })
}

@Composable
private fun ExplorePageTabLocationsContent(navController: NavController) {
    val viewModel = viewModel<ExploreLocationsViewModel>()
    val data by viewModel.getLocations(viewModel<ExploreViewModel>().displayOnlyFavorite)
        .collectAsState()

    LocationsList(
        data = data,
        modifier = Modifier.fillMaxSize(),
        onFavoriteChanged = { item, favorite -> viewModel.setFavorite(item.id, favorite) },
        onClick = { item ->
            navController.navigate("/locations/${item.id}")
        })
}

@Composable
@Preview
private fun PreviewExplorePageTopBar() {
    TheRickAndMortyEncyclopediaTheme {
        ExplorePageTopBar(false) {}
    }
}
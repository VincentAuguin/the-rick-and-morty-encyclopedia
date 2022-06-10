package fr.ippon.trame.explore.episode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.ippon.trame.episode.GetAllEpisodesUseCase
import fr.ippon.trame.episode.GetAllFavoriteEpisodesUseCase
import fr.ippon.trame.episode.SetEpisodeFavoriteUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class ExploreEpisodesViewModel @Inject constructor(
    private val getAllEpisodes: GetAllEpisodesUseCase,
    private val getAllFavoriteEpisodes: GetAllFavoriteEpisodesUseCase,
    private val transformToEpisodesListData: EpisodesToEpisodesListDataTransformer,
    private val setEpisodeFavorite: SetEpisodeFavoriteUseCase,
) : ViewModel() {

    fun getEpisodes(favoriteOnly: Flow<Boolean>): StateFlow<EpisodesListData> = favoriteOnly
        .flatMapLatest { favorite ->
            if (favorite) {
                getAllFavoriteEpisodes()
            } else {
                getAllEpisodes()
            }
        }
        .map(transformToEpisodesListData::invoke)
        .stateIn(
            viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = EpisodesListData(
                emptyList()
            )
        )

    fun setFavorite(episodeId: String, favorite: Boolean) {
        viewModelScope.launch {
            setEpisodeFavorite(episodeId, favorite)
        }
    }
}
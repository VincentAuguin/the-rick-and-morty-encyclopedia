package fr.ippon.trame.explore.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.ippon.trame.character.GetAllCharactersUseCase
import fr.ippon.trame.character.GetAllFavoriteCharactersUseCase
import fr.ippon.trame.character.SetCharacterFavoriteUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class ExploreCharactersViewModel @Inject constructor(
    private val getAllCharacters: GetAllCharactersUseCase,
    private val getAllFavoriteCharacters: GetAllFavoriteCharactersUseCase,
    private val transformToCharactersListData: CharactersToCharactersListDataTransformer,
    private val setCharacterFavorite: SetCharacterFavoriteUseCase,
) : ViewModel() {

    fun getCharacters(favoriteOnly: Flow<Boolean>): StateFlow<CharactersListData> = favoriteOnly
        .flatMapLatest { favorite ->
            if (favorite) {
                getAllFavoriteCharacters()
            } else {
                getAllCharacters()
            }
        }
        .map(transformToCharactersListData::invoke)
        .stateIn(
            viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = CharactersListData(
                emptyList()
            )
        )

    fun setFavorite(characterId: String, favorite: Boolean) {
        viewModelScope.launch {
            setCharacterFavorite(characterId, favorite)
        }
    }
}
package fr.ippon.trame.explore.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.ippon.trame.location.GetAllFavoriteLocationsUseCase
import fr.ippon.trame.location.GetAllLocationsUseCase
import fr.ippon.trame.location.SetLocationFavoriteUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class ExploreLocationsViewModel @Inject constructor(
    private val getAllLocations: GetAllLocationsUseCase,
    private val getAllFavoriteLocationsUseCase: GetAllFavoriteLocationsUseCase,
    private val transformToLocationsListData: LocationsToLocationsListDataTransformer,
    private val setLocationFavorite: SetLocationFavoriteUseCase,
) : ViewModel() {

    fun getLocations(favoriteOnly: Flow<Boolean>): StateFlow<LocationsListData> = favoriteOnly
        .flatMapLatest { favorite ->
            if (favorite) {
                getAllFavoriteLocationsUseCase()
            } else {
                getAllLocations()
            }
        }
        .map(transformToLocationsListData::invoke)
        .stateIn(
            viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = LocationsListData(
                emptyList()
            )
        )

    fun setFavorite(locationId: String, favorite: Boolean) {
        viewModelScope.launch {
            setLocationFavorite(locationId, favorite)
        }
    }
}
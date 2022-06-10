package fr.ippon.trame.explore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.ippon.trame.RefreshDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(private val refreshData: RefreshDataUseCase) :
    ViewModel() {
    private val _displayOnlyFavorite = MutableStateFlow(false)
    val displayOnlyFavorite: StateFlow<Boolean> = _displayOnlyFavorite

    fun toggleFavoriteDisplay() {
        _displayOnlyFavorite.value = !_displayOnlyFavorite.value
    }

    fun refreshData() {
        viewModelScope.launch { refreshData.invoke() }
    }
}
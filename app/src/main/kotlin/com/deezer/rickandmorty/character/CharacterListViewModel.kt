package com.deezer.rickandmorty.character

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(): ViewModel() {

    val characters: StateFlow<List<CharacterListItemData>> = MutableStateFlow(listOf(
        CharacterListItemData(
            id = "1",
            name = "Rick",
            image = ""
        ),
        CharacterListItemData(
            id = "2",
            name = "Morty",
            image = ""
        ),
        CharacterListItemData(
            id = "3",
            name = "Summer",
            image = ""
        ),
    ))
}
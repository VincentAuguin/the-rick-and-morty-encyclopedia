package fr.ippon.trame.character

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetAllFavoriteCharactersUseCase {
    operator fun invoke(): Flow<List<Character>>
}

class DefaultGetAllFavoriteCharactersUseCase @Inject constructor(private val getAllCharacters: GetAllCharactersUseCase) :
    GetAllFavoriteCharactersUseCase {
    override fun invoke(): Flow<List<Character>> {
        return getAllCharacters().map { it.filter { character -> character.isFavorite } }
    }
}
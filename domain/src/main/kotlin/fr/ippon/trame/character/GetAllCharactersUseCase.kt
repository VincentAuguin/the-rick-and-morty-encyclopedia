package fr.ippon.trame.character

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

interface GetAllCharactersUseCase {
    operator fun invoke(): Flow<List<Character>>
}

class DefaultGetAllCharactersUseCase @Inject constructor(private val repository: CharacterRepository) :
    GetAllCharactersUseCase {
    override fun invoke(): Flow<List<Character>> {
        return repository.getAll().distinctUntilChanged()
    }
}
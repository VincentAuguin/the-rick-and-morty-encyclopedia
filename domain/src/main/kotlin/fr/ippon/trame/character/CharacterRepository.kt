package fr.ippon.trame.character

import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getAll(): Flow<List<Character>>
    suspend fun getById(id: String): Character?
    suspend fun update(character: Character)
    suspend fun refresh()
}
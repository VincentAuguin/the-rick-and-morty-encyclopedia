package fr.ippon.trame.character.network

import fr.ippon.trame.character.network.rest.CharacterDto

interface RemoteCharacterDataSource {
    suspend fun getAll(): List<CharacterDto>
}
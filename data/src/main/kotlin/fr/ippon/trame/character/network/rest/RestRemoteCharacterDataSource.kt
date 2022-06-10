package fr.ippon.trame.character.network.rest

import fr.ippon.trame.character.network.RemoteCharacterDataSource
import javax.inject.Inject

class RestRemoteCharacterDataSource @Inject constructor(
    private val characterApiService: CharacterApiService
) : RemoteCharacterDataSource {

    override suspend fun getAll(): List<CharacterDto> {
        return characterApiService.listCharacters().results
    }
}
package fr.ippon.trame.character.network.rest

import fr.ippon.trame.shared.PaginatedDto
import retrofit2.http.GET

interface CharacterApiService {

    @GET("character")
    suspend fun listCharacters(): PaginatedDto<CharacterDto>
}
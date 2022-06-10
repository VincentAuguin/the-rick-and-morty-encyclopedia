package fr.ippon.trame.episode.network.rest

import fr.ippon.trame.shared.PaginatedDto
import retrofit2.http.GET

interface EpisodeApiService {

    @GET("episode")
    suspend fun listEpisodes(): PaginatedDto<EpisodeDto>
}
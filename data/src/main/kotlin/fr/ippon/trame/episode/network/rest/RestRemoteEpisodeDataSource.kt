package fr.ippon.trame.episode.network.rest

import fr.ippon.trame.episode.network.RemoteEpisodeDataSource
import javax.inject.Inject

class RestRemoteEpisodeDataSource @Inject constructor(
    private val characterApiService: EpisodeApiService
) : RemoteEpisodeDataSource {

    override suspend fun getAll(): List<EpisodeDto> {
        return characterApiService.listEpisodes().results
    }
}
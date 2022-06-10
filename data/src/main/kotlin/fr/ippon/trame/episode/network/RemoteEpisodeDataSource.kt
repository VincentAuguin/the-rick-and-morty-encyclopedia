package fr.ippon.trame.episode.network

import fr.ippon.trame.episode.network.rest.EpisodeDto

interface RemoteEpisodeDataSource {
    suspend fun getAll(): List<EpisodeDto>
}
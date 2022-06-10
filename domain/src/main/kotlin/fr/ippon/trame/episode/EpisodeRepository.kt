package fr.ippon.trame.episode

import kotlinx.coroutines.flow.Flow

interface EpisodeRepository {
    fun getAll(): Flow<List<Episode>>
    suspend fun getById(id: String): Episode?
    suspend fun update(episode: Episode)
    suspend fun refresh()
}
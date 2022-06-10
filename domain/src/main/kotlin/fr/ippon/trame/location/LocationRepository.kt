package fr.ippon.trame.location

import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    fun getAll(): Flow<List<Location>>
    suspend fun getById(id: String): Location?
    suspend fun update(episode: Location)
    suspend fun refresh()
}
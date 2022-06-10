package fr.ippon.trame.shared.persistence

import kotlinx.coroutines.flow.Flow

interface BaseLocalDataSource<T> {
    fun getAll(): Flow<List<T>>
    suspend fun getById(id: String): T?
    suspend fun update(obj: T)
}
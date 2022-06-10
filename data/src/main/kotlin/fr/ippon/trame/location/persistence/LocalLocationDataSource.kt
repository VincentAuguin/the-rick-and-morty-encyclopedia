package fr.ippon.trame.location.persistence

import fr.ippon.trame.location.persistence.room.LocationEntity
import fr.ippon.trame.location.persistence.room.LocationUpdateEntity
import fr.ippon.trame.shared.persistence.BaseLocalDataSource

interface LocalLocationDataSource : BaseLocalDataSource<LocationEntity> {
    suspend fun upsert(entities: List<LocationUpdateEntity>)
}
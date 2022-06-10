package fr.ippon.trame.location

import fr.ippon.trame.location.network.RemoteLocationDataSource
import fr.ippon.trame.location.network.rest.LocationDto
import fr.ippon.trame.location.persistence.LocalLocationDataSource
import fr.ippon.trame.location.persistence.room.LocationEntity
import fr.ippon.trame.location.persistence.room.LocationUpdateEntity
import fr.ippon.trame.shared.RepositoryCoroutineContext
import fr.ippon.trame.shared.RestDataSource
import fr.ippon.trame.shared.RoomDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DefaultLocationRepository @Inject constructor(
    @RestDataSource private val remoteDataSource: RemoteLocationDataSource,
    @RoomDataSource private val localDataSource: LocalLocationDataSource,
    @RepositoryCoroutineContext private val coroutineContext: CoroutineContext
) : LocationRepository {

    override fun getAll(): Flow<List<Location>> {
        return localDataSource.getAll().map { it.map { entity -> entity.toModel() } }
    }

    override suspend fun getById(id: String): Location? {
        return localDataSource.getById(id)?.toModel()
    }

    override suspend fun update(episode: Location) {
        localDataSource.update(episode.toEntity())
    }

    override suspend fun refresh() {
        withContext(coroutineContext) {
            val dto = remoteDataSource.getAll()
            localDataSource.upsert(dto.map { it.toUpdateEntity() })
        }
    }

    private fun LocationDto.toUpdateEntity() = LocationUpdateEntity(
        id = id,
        name = name.orEmpty(),
        dimension = dimension.orEmpty()
    )

    private fun LocationEntity.toModel() = Location(
        id = id.toString(),
        name = name,
        dimension = dimension,
        isFavorite = isFavorite
    )

    private fun Location.toEntity() = LocationEntity(
        id = id.toInt(),
        name = name,
        dimension = dimension,
        isFavorite = isFavorite
    )
}
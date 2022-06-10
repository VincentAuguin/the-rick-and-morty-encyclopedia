package fr.ippon.trame.location.persistence.room

import fr.ippon.trame.location.persistence.LocalLocationDataSource
import fr.ippon.trame.shared.LocalDataSourceCoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class RoomLocalLocationDataSource @Inject constructor(
    private val dao: LocationDao,
    @LocalDataSourceCoroutineContext private val coroutineContext: CoroutineContext
) : LocalLocationDataSource {

    override fun getAll(): Flow<List<LocationEntity>> {
        return dao.readAllAsFlow()
    }

    override suspend fun getById(id: String): LocationEntity? = withContext(coroutineContext) {
        dao.readById(id)
    }

    override suspend fun upsert(entities: List<LocationUpdateEntity>) =
        withContext(coroutineContext) {
            dao.upsert(entities)
        }

    override suspend fun update(obj: LocationEntity) = withContext(coroutineContext) {
        dao.update(obj)
    }
}
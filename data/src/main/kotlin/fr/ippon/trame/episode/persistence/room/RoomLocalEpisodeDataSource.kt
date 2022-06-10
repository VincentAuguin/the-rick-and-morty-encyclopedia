package fr.ippon.trame.episode.persistence.room

import fr.ippon.trame.episode.persistence.LocalEpisodeDataSource
import fr.ippon.trame.shared.LocalDataSourceCoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class RoomLocalEpisodeDataSource @Inject constructor(
    private val dao: EpisodeDao,
    @LocalDataSourceCoroutineContext private val coroutineContext: CoroutineContext
) : LocalEpisodeDataSource {

    override fun getAll(): Flow<List<EpisodeEntity>> {
        return dao.readAllAsFlow()
    }

    override suspend fun getById(id: String): EpisodeEntity? = withContext(coroutineContext) {
        dao.readById(id)
    }

    override suspend fun upsert(entities: List<EpisodeUpdateEntity>) =
        withContext(coroutineContext) {
            dao.upsert(entities)
        }

    override suspend fun update(obj: EpisodeEntity) = withContext(coroutineContext) {
        dao.update(obj)
    }
}
package fr.ippon.trame.episode

import fr.ippon.trame.episode.network.RemoteEpisodeDataSource
import fr.ippon.trame.episode.network.rest.EpisodeDto
import fr.ippon.trame.episode.persistence.LocalEpisodeDataSource
import fr.ippon.trame.episode.persistence.room.EpisodeEntity
import fr.ippon.trame.episode.persistence.room.EpisodeUpdateEntity
import fr.ippon.trame.shared.RepositoryCoroutineContext
import fr.ippon.trame.shared.RestDataSource
import fr.ippon.trame.shared.RoomDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DefaultEpisodeRepository @Inject constructor(
    @RestDataSource private val remoteDataSource: RemoteEpisodeDataSource,
    @RoomDataSource private val localDataSource: LocalEpisodeDataSource,
    @RepositoryCoroutineContext private val coroutineContext: CoroutineContext
) : EpisodeRepository {

    override fun getAll(): Flow<List<Episode>> {
        return localDataSource.getAll().map { it.map { entity -> entity.toModel() } }
    }

    override suspend fun getById(id: String): Episode? {
        return localDataSource.getById(id)?.toModel()
    }

    override suspend fun update(episode: Episode) {
        localDataSource.update(episode.toEntity())
    }

    override suspend fun refresh() {
        withContext(coroutineContext) {
            val dto = remoteDataSource.getAll()
            localDataSource.upsert(dto.map { it.toUpdateEntity() })
        }
    }

    private fun EpisodeDto.toUpdateEntity() = EpisodeUpdateEntity(
        id = id,
        name = name.orEmpty(),
        episode = episode.orEmpty()
    )

    private fun EpisodeEntity.toModel() = Episode(
        id = id.toString(),
        name = name,
        episode = episode,
        isFavorite = isFavorite
    )

    private fun Episode.toEntity() = EpisodeEntity(
        id = id.toInt(),
        name = name,
        episode = episode,
        isFavorite = isFavorite
    )
}
package fr.ippon.trame.episode.persistence

import fr.ippon.trame.episode.persistence.room.EpisodeEntity
import fr.ippon.trame.episode.persistence.room.EpisodeUpdateEntity
import fr.ippon.trame.shared.persistence.BaseLocalDataSource

interface LocalEpisodeDataSource : BaseLocalDataSource<EpisodeEntity> {
    suspend fun upsert(entities: List<EpisodeUpdateEntity>)
}
package fr.ippon.trame.episode.persistence.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "episode")
data class EpisodeEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val episode: String,
    @ColumnInfo val isFavorite: Boolean,
)

@Entity
data class EpisodeUpdateEntity(
    @ColumnInfo val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val episode: String,
)

fun EpisodeUpdateEntity.toEntity() = EpisodeEntity(
    id = id,
    name = name,
    episode = episode,
    isFavorite = false,
)
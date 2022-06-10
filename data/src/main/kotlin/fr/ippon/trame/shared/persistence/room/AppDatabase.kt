package fr.ippon.trame.shared.persistence.room

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.ippon.trame.character.persistence.room.CharacterDao
import fr.ippon.trame.character.persistence.room.CharacterEntity
import fr.ippon.trame.episode.persistence.room.EpisodeDao
import fr.ippon.trame.episode.persistence.room.EpisodeEntity
import fr.ippon.trame.location.persistence.room.LocationDao
import fr.ippon.trame.location.persistence.room.LocationEntity

@Database(
    entities = [CharacterEntity::class, EpisodeEntity::class, LocationEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun episodeDao(): EpisodeDao
    abstract fun locationDao(): LocationDao
}
package fr.ippon.trame.shared.persistence.room

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.ippon.trame.character.persistence.room.CharacterDao
import fr.ippon.trame.character.persistence.room.CharacterEntity
import fr.ippon.trame.episode.persistence.room.EpisodeDao
import fr.ippon.trame.episode.persistence.room.EpisodeEntity

@Database(entities = [CharacterEntity::class, EpisodeEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun episodeDao(): EpisodeDao
}
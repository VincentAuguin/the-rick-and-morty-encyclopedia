package fr.ippon.trame.shared.persistence.room

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.ippon.trame.character.persistence.room.CharacterDao
import fr.ippon.trame.character.persistence.room.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}
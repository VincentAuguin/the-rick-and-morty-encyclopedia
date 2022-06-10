package fr.ippon.trame.character.persistence.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character")
data class CharacterEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val imageUrl: String,
    @ColumnInfo val isFavorite: Boolean,
)

@Entity
data class CharacterUpdateEntity(
    @ColumnInfo val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val imageUrl: String,
)

fun CharacterUpdateEntity.toEntity() = CharacterEntity(
    id = id,
    name = name,
    imageUrl = imageUrl,
    isFavorite = false,
)
package fr.ippon.trame.location.persistence.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location")
data class LocationEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val dimension: String,
    @ColumnInfo val isFavorite: Boolean,
)

@Entity
data class LocationUpdateEntity(
    @ColumnInfo val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val dimension: String,
)

fun LocationUpdateEntity.toEntity() = LocationEntity(
    id = id,
    name = name,
    dimension = dimension,
    isFavorite = false,
)
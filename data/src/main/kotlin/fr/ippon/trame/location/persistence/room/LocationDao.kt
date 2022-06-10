package fr.ippon.trame.location.persistence.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
abstract class LocationDao {

    @Query("SELECT * FROM location")
    abstract fun readAllAsFlow(): Flow<List<LocationEntity>>

    @Query("SELECT * FROM location WHERE id == :id LIMIT 1")
    abstract fun readById(id: String): LocationEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(obj: LocationEntity): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(obj: List<LocationEntity>?): List<Long>

    @Update
    abstract fun update(obj: LocationEntity)

    @Update
    abstract fun update(obj: List<LocationEntity>?)

    @Update(entity = LocationEntity::class)
    abstract fun updatePartial(obj: LocationUpdateEntity)

    @Update(entity = LocationEntity::class)
    abstract fun updatePartial(obj: List<LocationUpdateEntity>?)

    @Transaction
    open fun upsert(obj: LocationUpdateEntity) {
        val id = insert(obj.toEntity())
        if (id == -1L) {
            updatePartial(obj)
        }
    }

    @Transaction
    open fun upsert(objList: List<LocationUpdateEntity>) {
        val insertResult =
            insert(objList.map { it.toEntity() })
        val updateList: MutableList<LocationUpdateEntity> = ArrayList()
        for (i in insertResult.indices) {
            if (insertResult[i] == -1L) {
                updateList.add(objList[i])
            }
        }
        if (updateList.isNotEmpty()) {
            updatePartial(updateList)
        }
    }
}
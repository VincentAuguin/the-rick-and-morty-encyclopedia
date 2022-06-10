package fr.ippon.trame.episode.persistence.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
abstract class EpisodeDao {

    @Query("SELECT * FROM episode")
    abstract fun readAllAsFlow(): Flow<List<EpisodeEntity>>

    @Query("SELECT * FROM episode WHERE id == :id LIMIT 1")
    abstract fun readById(id: String): EpisodeEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(obj: EpisodeEntity): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(obj: List<EpisodeEntity>?): List<Long>

    @Update
    abstract fun update(obj: EpisodeEntity)

    @Update
    abstract fun update(obj: List<EpisodeEntity>?)

    @Update(entity = EpisodeEntity::class)
    abstract fun updatePartial(obj: EpisodeUpdateEntity)

    @Update(entity = EpisodeEntity::class)
    abstract fun updatePartial(obj: List<EpisodeUpdateEntity>?)

    @Transaction
    open fun upsert(obj: EpisodeUpdateEntity) {
        val id = insert(obj.toEntity())
        if (id == -1L) {
            updatePartial(obj)
        }
    }

    @Transaction
    open fun upsert(objList: List<EpisodeUpdateEntity>) {
        val insertResult =
            insert(objList.map { it.toEntity() })
        val updateList: MutableList<EpisodeUpdateEntity> = ArrayList()
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
package fr.ippon.trame.character.persistence.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CharacterDao {

    @Query("SELECT * FROM character")
    abstract fun readAllAsFlow(): Flow<List<CharacterEntity>>

    @Query("SELECT * FROM character WHERE id == :id LIMIT 1")
    abstract fun readById(id: String): CharacterEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(obj: CharacterEntity): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(obj: List<CharacterEntity>?): List<Long>

    @Update
    abstract fun update(obj: CharacterEntity)

    @Update
    abstract fun update(obj: List<CharacterEntity>?)

    @Update(entity = CharacterEntity::class)
    abstract fun updatePartial(obj: CharacterUpdateEntity)

    @Update(entity = CharacterEntity::class)
    abstract fun updatePartial(obj: List<CharacterUpdateEntity>?)

    @Transaction
    open fun upsert(obj: CharacterUpdateEntity) {
        val id = insert(obj.toEntity())
        if (id == -1L) {
            updatePartial(obj)
        }
    }

    @Transaction
    open fun upsert(objList: List<CharacterUpdateEntity>) {
        val insertResult =
            insert(objList.map { it.toEntity() })
        val updateList: MutableList<CharacterUpdateEntity> = ArrayList()
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
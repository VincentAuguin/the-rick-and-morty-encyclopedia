package fr.ippon.trame.character.persistence.room

import fr.ippon.trame.character.persistence.LocalCharacterDataSource
import fr.ippon.trame.shared.LocalDataSourceCoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class RoomLocalCharacterDataSource @Inject constructor(
    private val dao: CharacterDao,
    @LocalDataSourceCoroutineContext private val coroutineContext: CoroutineContext
) :
    LocalCharacterDataSource {

    override fun getAll(): Flow<List<CharacterEntity>> {
        return dao.readAllAsFlow()
    }

    override suspend fun getById(id: String): CharacterEntity? = withContext(coroutineContext) {
        dao.readById(id)
    }

    override suspend fun upsert(entities: List<CharacterUpdateEntity>) =
        withContext(coroutineContext) {
            dao.upsert(entities)
        }

    override suspend fun update(obj: CharacterEntity) = withContext(coroutineContext) {
        dao.update(obj)
    }
}
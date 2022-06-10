package fr.ippon.trame.character

import fr.ippon.trame.character.network.RemoteCharacterDataSource
import fr.ippon.trame.character.network.rest.CharacterDto
import fr.ippon.trame.character.persistence.LocalCharacterDataSource
import fr.ippon.trame.character.persistence.room.CharacterEntity
import fr.ippon.trame.character.persistence.room.CharacterUpdateEntity
import fr.ippon.trame.shared.RepositoryCoroutineContext
import fr.ippon.trame.shared.RestDataSource
import fr.ippon.trame.shared.RoomDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DefaultCharacterRepository @Inject constructor(
    @RestDataSource private val remoteDataSource: RemoteCharacterDataSource,
    @RoomDataSource private val localDataSource: LocalCharacterDataSource,
    @RepositoryCoroutineContext private val coroutineContext: CoroutineContext
) : CharacterRepository {

    override fun getAll(): Flow<List<Character>> {
        return localDataSource.getAll().map { it.map { entity -> entity.toModel() } }
    }

    override suspend fun getById(id: String): Character? {
        return localDataSource.getById(id)?.toModel()
    }

    override suspend fun update(character: Character) {
        localDataSource.update(character.toEntity())
    }

    override suspend fun refresh() {
        withContext(coroutineContext) {
            val dto = remoteDataSource.getAll()
            localDataSource.upsert(dto.map { it.toUpdateEntity() })
        }
    }

    private fun CharacterDto.toUpdateEntity() = CharacterUpdateEntity(
        id = id,
        name = name.orEmpty(),
        imageUrl = image.orEmpty()
    )

    private fun CharacterEntity.toModel() = Character(
        id = id.toString(),
        name = name,
        imageUrl = imageUrl,
        isFavorite = isFavorite
    )

    private fun Character.toEntity() = CharacterEntity(
        id = id.toInt(),
        name = name,
        imageUrl = imageUrl,
        isFavorite = isFavorite
    )
}
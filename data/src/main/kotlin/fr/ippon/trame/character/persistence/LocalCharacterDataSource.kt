package fr.ippon.trame.character.persistence

import fr.ippon.trame.character.persistence.room.CharacterEntity
import fr.ippon.trame.character.persistence.room.CharacterUpdateEntity
import fr.ippon.trame.shared.persistence.BaseLocalDataSource

interface LocalCharacterDataSource : BaseLocalDataSource<CharacterEntity> {
    suspend fun upsert(entities: List<CharacterUpdateEntity>)
}
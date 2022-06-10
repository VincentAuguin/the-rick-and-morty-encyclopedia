package fr.ippon.trame.character

import javax.inject.Inject

interface SetCharacterFavoriteUseCase {
    suspend operator fun invoke(characterId: String, favorite: Boolean)
}

class DefaultSetCharacterFavoriteUseCase @Inject constructor(private val repository: CharacterRepository) : SetCharacterFavoriteUseCase {
    override suspend operator fun invoke(characterId: String, favorite: Boolean) {
        repository.getById(characterId)?.let { character ->
            repository.update(character.copy(isFavorite = favorite))
        }
    }
}
package fr.ippon.trame

import fr.ippon.trame.character.CharacterRepository
import javax.inject.Inject

interface RefreshDataUseCase {
    suspend operator fun invoke()
}

class DefaultRefreshDataUseCase @Inject constructor(private val characterRepository: CharacterRepository) :
    RefreshDataUseCase {

    override suspend fun invoke() {
        characterRepository.refresh()
    }
}
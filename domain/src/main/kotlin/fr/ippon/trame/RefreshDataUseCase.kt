package fr.ippon.trame

import fr.ippon.trame.character.CharacterRepository
import fr.ippon.trame.episode.EpisodeRepository
import fr.ippon.trame.location.LocationRepository
import javax.inject.Inject

interface RefreshDataUseCase {
    suspend operator fun invoke()
}

class DefaultRefreshDataUseCase @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val episodeRepository: EpisodeRepository,
    private val locationRepository: LocationRepository
) :
    RefreshDataUseCase {

    override suspend fun invoke() {
        characterRepository.refresh()
        episodeRepository.refresh()
        locationRepository.refresh()
    }
}
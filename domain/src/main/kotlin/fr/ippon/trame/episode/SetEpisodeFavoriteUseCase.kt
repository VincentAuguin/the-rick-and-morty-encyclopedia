package fr.ippon.trame.episode

import javax.inject.Inject

interface SetEpisodeFavoriteUseCase {
    suspend operator fun invoke(episodeId: String, favorite: Boolean)
}

class DefaultSetEpisodeFavoriteUseCase @Inject constructor(private val repository: EpisodeRepository) :
    SetEpisodeFavoriteUseCase {
    override suspend fun invoke(episodeId: String, favorite: Boolean) {
        repository.getById(episodeId)?.let { episode ->
            repository.update(episode.copy(isFavorite = favorite))
        }
    }
}
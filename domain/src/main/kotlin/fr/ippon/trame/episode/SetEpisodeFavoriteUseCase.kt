package fr.ippon.trame.episode

import javax.inject.Inject

interface SetEpisodeFavoriteUseCase {
    operator fun invoke(episodeId: String, favorite: Boolean)
}

class DefaultSetEpisodeFavoriteUseCase @Inject constructor() : SetEpisodeFavoriteUseCase {
    override fun invoke(episodeId: String, favorite: Boolean) {

    }
}
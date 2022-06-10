package fr.ippon.trame.episode

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetAllFavoriteEpisodesUseCase {
    operator fun invoke(): Flow<List<Episode>>
}

class DefaultGetAllFavoriteEpisodesUseCase @Inject constructor(private val getAllEpisodes: GetAllEpisodesUseCase) :
    GetAllFavoriteEpisodesUseCase {
    override fun invoke(): Flow<List<Episode>> {
        return getAllEpisodes().map { it.filter { episode -> episode.isFavorite } }
    }
}
package fr.ippon.trame.episode

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

interface GetAllEpisodesUseCase {
    operator fun invoke(): Flow<List<Episode>>
}

class DefaultGetAllEpisodesUseCase @Inject constructor() : GetAllEpisodesUseCase {
    override fun invoke(): Flow<List<Episode>> {
        return flowOf(
            listOf(
                Episode(
                    id = "1",
                    name = "Pilot",
                    episode = "S01E01",
                    isFavorite = false
                ),
                Episode(
                    id = "2",
                    name = "Lawnmower Dog",
                    episode = "S01E02",
                    isFavorite = false
                ),
                Episode(
                    id = "3",
                    name = "Anatomy Park",
                    episode = "S01E03",
                    isFavorite = true
                ),
                Episode(
                    id = "4",
                    name = "M. Night Shaym-Aliens!",
                    episode = "S01E04",
                    isFavorite = true
                ),
            )
        )
    }
}
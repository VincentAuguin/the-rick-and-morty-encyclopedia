package fr.ippon.trame.episode

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

interface GetAllEpisodesUseCase {
    operator fun invoke(): Flow<List<Episode>>
}

class DefaultGetAllEpisodesUseCase @Inject constructor(private val repository: EpisodeRepository) :
    GetAllEpisodesUseCase {
    override fun invoke(): Flow<List<Episode>> {
        return repository.getAll().distinctUntilChanged()
    }
}
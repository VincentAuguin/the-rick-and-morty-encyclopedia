package fr.ippon.trame.explore.episode

import fr.ippon.trame.episode.Episode
import javax.inject.Inject

interface EpisodesToEpisodesListDataTransformer {
    operator fun invoke(episodes: List<Episode>): EpisodesListData
}

class EpisodesToEpisodesListDataTransformerImpl @Inject constructor(private val transformToEpisodesListItemData: EpisodeToEpisodesListItemDataTransformer) :
    EpisodesToEpisodesListDataTransformer {
    override fun invoke(episodes: List<Episode>): EpisodesListData {
        return EpisodesListData(episodes = episodes.map(transformToEpisodesListItemData::invoke))
    }
}
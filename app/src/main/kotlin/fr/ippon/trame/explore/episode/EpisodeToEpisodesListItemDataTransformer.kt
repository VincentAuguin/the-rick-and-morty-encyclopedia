package fr.ippon.trame.explore.episode

import fr.ippon.trame.episode.Episode
import javax.inject.Inject

interface EpisodeToEpisodesListItemDataTransformer {
    operator fun invoke(episode: Episode): EpisodesListItemData
}

class EpisodeToEpisodesListItemDataTransformerImpl @Inject constructor() :
    EpisodeToEpisodesListItemDataTransformer {
    override fun invoke(episode: Episode): EpisodesListItemData {
        return EpisodesListItemData(
            id = episode.id,
            name = "${episode.episode} — ${episode.name}",
            favorite = episode.isFavorite
        )
    }
}
package fr.ippon.trame.explore.episode

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface TransformersModule {

    @Binds
    fun bindEpisodesToEpisodesListDataTransformer(impl: EpisodesToEpisodesListDataTransformerImpl): EpisodesToEpisodesListDataTransformer

    @Binds
    fun bindEpisodeToEpisodesListItemDataTransformer(impl: EpisodeToEpisodesListItemDataTransformerImpl): EpisodeToEpisodesListItemDataTransformer
}
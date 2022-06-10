package fr.ippon.trame.shared.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.ippon.trame.character.CharacterRepository
import fr.ippon.trame.character.DefaultCharacterRepository
import fr.ippon.trame.episode.DefaultEpisodeRepository
import fr.ippon.trame.episode.EpisodeRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    @Singleton
    fun bindCharacterRepository(impl: DefaultCharacterRepository): CharacterRepository

    @Binds
    @Singleton
    fun bindEpisodeRepository(impl: DefaultEpisodeRepository): EpisodeRepository
}
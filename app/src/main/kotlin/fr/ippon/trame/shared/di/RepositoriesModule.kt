package fr.ippon.trame.shared.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.ippon.trame.character.CharacterRepository
import fr.ippon.trame.character.DefaultCharacterRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    @Singleton
    fun bindCharacterRepository(impl: DefaultCharacterRepository): CharacterRepository
}
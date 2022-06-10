package fr.ippon.trame.explore.character

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface TransformersModule {

    @Binds
    fun bindCharactersToCharactersListDataTransformer(impl: CharactersToCharactersListDataTransformerImpl): CharactersToCharactersListDataTransformer

    @Binds
    fun bindCharacterToCharactersListItemDataTransformer(impl: CharacterToCharactersListItemDataTransformerImpl): CharacterToCharactersListItemDataTransformer
}
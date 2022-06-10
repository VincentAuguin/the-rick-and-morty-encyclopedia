package fr.ippon.trame.shared.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import fr.ippon.trame.DefaultRefreshDataUseCase
import fr.ippon.trame.RefreshDataUseCase
import fr.ippon.trame.character.*
import fr.ippon.trame.episode.*
import fr.ippon.trame.location.*

@Module
@InstallIn(ViewModelComponent::class)
interface UseCasesModule {

    @Binds
    fun bindGetAllCharactersUseCase(impl: DefaultGetAllCharactersUseCase): GetAllCharactersUseCase

    @Binds
    fun bindGetAllFavoriteCharactersUseCase(impl: DefaultGetAllFavoriteCharactersUseCase): GetAllFavoriteCharactersUseCase

    @Binds
    fun bindGetAllEpisodesUseCase(impl: DefaultGetAllEpisodesUseCase): GetAllEpisodesUseCase

    @Binds
    fun bindGetAllFavoriteEpisodesUseCase(impl: DefaultGetAllFavoriteEpisodesUseCase): GetAllFavoriteEpisodesUseCase

    @Binds
    fun bindGetAllLocationsUseCase(impl: DefaultGetAllLocationsUseCase): GetAllLocationsUseCase

    @Binds
    fun bindGetAllFavoriteLocationsUseCase(impl: DefaultGetAllFavoriteLocationsUseCase): GetAllFavoriteLocationsUseCase

    @Binds
    fun bindSetCharacterFavoriteUseCase(impl: DefaultSetCharacterFavoriteUseCase): SetCharacterFavoriteUseCase

    @Binds
    fun bindSetEpisodeFavoriteUseCase(impl: DefaultSetEpisodeFavoriteUseCase): SetEpisodeFavoriteUseCase

    @Binds
    fun bindSetLocationFavoriteUseCase(impl: DefaultSetLocationFavoriteUseCase): SetLocationFavoriteUseCase

    @Binds
    fun bindRefreshDataUseCase(impl: DefaultRefreshDataUseCase): RefreshDataUseCase
}
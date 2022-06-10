package fr.ippon.trame.explore.location

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface TransformersModule {

    @Binds
    fun bindLocationsToLocationsListDataTransformer(impl: LocationsToLocationsListDataTransformerImpl): LocationsToLocationsListDataTransformer

    @Binds
    fun bindLocationToLocationsListItemDataTransformer(impl: LocationToLocationsListItemDataTransformerImpl): LocationToLocationsListItemDataTransformer
}
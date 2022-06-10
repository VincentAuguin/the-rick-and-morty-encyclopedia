package fr.ippon.trame.shared.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.ippon.trame.character.network.RemoteCharacterDataSource
import fr.ippon.trame.character.network.rest.RestRemoteCharacterDataSource
import fr.ippon.trame.character.persistence.LocalCharacterDataSource
import fr.ippon.trame.character.persistence.room.RoomLocalCharacterDataSource
import fr.ippon.trame.shared.RestDataSource
import fr.ippon.trame.shared.RoomDataSource

@Module
@InstallIn(SingletonComponent::class)
interface DataSourcesModule {

    @Binds
    @RestDataSource
    fun bindRemoteCharacterDataSource(impl: RestRemoteCharacterDataSource): RemoteCharacterDataSource

    @Binds
    @RoomDataSource
    fun bindLocalCharacterDataSource(impl: RoomLocalCharacterDataSource): LocalCharacterDataSource
}
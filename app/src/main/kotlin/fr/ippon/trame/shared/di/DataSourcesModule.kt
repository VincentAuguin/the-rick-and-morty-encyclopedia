package fr.ippon.trame.shared.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.ippon.trame.character.network.RemoteCharacterDataSource
import fr.ippon.trame.character.network.rest.RestRemoteCharacterDataSource
import fr.ippon.trame.character.persistence.LocalCharacterDataSource
import fr.ippon.trame.character.persistence.room.RoomLocalCharacterDataSource
import fr.ippon.trame.episode.network.RemoteEpisodeDataSource
import fr.ippon.trame.episode.network.rest.RestRemoteEpisodeDataSource
import fr.ippon.trame.episode.persistence.LocalEpisodeDataSource
import fr.ippon.trame.episode.persistence.room.RoomLocalEpisodeDataSource
import fr.ippon.trame.location.network.RemoteLocationDataSource
import fr.ippon.trame.location.network.rest.RestRemoteLocationDataSource
import fr.ippon.trame.location.persistence.LocalLocationDataSource
import fr.ippon.trame.location.persistence.room.RoomLocalLocationDataSource
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

    @Binds
    @RestDataSource
    fun bindRemoteEpisodeDataSource(impl: RestRemoteEpisodeDataSource): RemoteEpisodeDataSource

    @Binds
    @RoomDataSource
    fun bindLocalEpisodeDataSource(impl: RoomLocalEpisodeDataSource): LocalEpisodeDataSource

    @Binds
    @RestDataSource
    fun bindRemoteLocationDataSource(impl: RestRemoteLocationDataSource): RemoteLocationDataSource

    @Binds
    @RoomDataSource
    fun bindLocalLocationDataSource(impl: RoomLocalLocationDataSource): LocalLocationDataSource
}
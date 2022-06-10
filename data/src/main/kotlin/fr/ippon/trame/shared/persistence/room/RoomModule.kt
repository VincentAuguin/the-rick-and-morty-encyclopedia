package fr.ippon.trame.shared.persistence.room

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fr.ippon.trame.character.persistence.room.CharacterDao
import fr.ippon.trame.episode.persistence.room.EpisodeDao
import fr.ippon.trame.location.persistence.room.LocationDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase = Room
        .databaseBuilder(context, AppDatabase::class.java, "App Database")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideCharacterDao(database: AppDatabase): CharacterDao = database.characterDao()

    @Provides
    fun provideEpisodeDao(database: AppDatabase): EpisodeDao = database.episodeDao()

    @Provides
    fun provideLocationDao(database: AppDatabase): LocationDao = database.locationDao()
}
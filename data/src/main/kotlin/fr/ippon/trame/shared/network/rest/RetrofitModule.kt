package fr.ippon.trame.shared.network.rest

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.ippon.trame.BuildConfig
import fr.ippon.trame.character.network.rest.CharacterApiService
import fr.ippon.trame.episode.network.rest.EpisodeApiService
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@OptIn(ExperimentalSerializationApi::class)
@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private val contentType = MediaType.parse("application/json")!!

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.REST_BASE_API_URI)
        .addConverterFactory(Json.asConverterFactory(contentType))
        .build()

    @Provides
    fun provideCharacterApiService(retrofit: Retrofit): CharacterApiService =
        retrofit.create(CharacterApiService::class.java)

    @Provides
    fun provideEpisodeApiService(retrofit: Retrofit): EpisodeApiService =
        retrofit.create(EpisodeApiService::class.java)
}
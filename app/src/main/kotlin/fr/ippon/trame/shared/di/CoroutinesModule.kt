package fr.ippon.trame.shared.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.ippon.trame.shared.LocalDataSourceCoroutineContext
import fr.ippon.trame.shared.RepositoryCoroutineContext
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object CoroutinesModule {

    @Provides
    @RepositoryCoroutineContext
    fun provideRepositoryCoroutineContext(): CoroutineContext =
        Dispatchers.IO + CoroutineName("Repository")

    @Provides
    @LocalDataSourceCoroutineContext
    fun provideLocalDataSourceCoroutineContext(): CoroutineContext =
        Dispatchers.Default + CoroutineName("Local Data Source")
}
package fr.ippon.trame.shared

import javax.inject.Qualifier

@Qualifier
annotation class RestDataSource

@Qualifier
annotation class RoomDataSource

@Qualifier
annotation class RepositoryCoroutineContext

@Qualifier
annotation class LocalDataSourceCoroutineContext
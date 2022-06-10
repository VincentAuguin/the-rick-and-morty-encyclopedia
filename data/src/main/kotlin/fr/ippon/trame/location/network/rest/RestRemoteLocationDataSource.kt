package fr.ippon.trame.location.network.rest

import fr.ippon.trame.location.network.RemoteLocationDataSource
import javax.inject.Inject

class RestRemoteLocationDataSource @Inject constructor(
    private val characterApiService: LocationApiService
) : RemoteLocationDataSource {

    override suspend fun getAll(): List<LocationDto> {
        return characterApiService.listLocations().results
    }
}
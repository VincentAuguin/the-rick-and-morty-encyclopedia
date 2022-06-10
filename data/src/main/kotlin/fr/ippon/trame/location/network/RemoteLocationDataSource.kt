package fr.ippon.trame.location.network

import fr.ippon.trame.location.network.rest.LocationDto

interface RemoteLocationDataSource {
    suspend fun getAll(): List<LocationDto>
}
package fr.ippon.trame.location.network.rest

import fr.ippon.trame.shared.PaginatedDto
import retrofit2.http.GET

interface LocationApiService {

    @GET("location")
    suspend fun listLocations(): PaginatedDto<LocationDto>
}
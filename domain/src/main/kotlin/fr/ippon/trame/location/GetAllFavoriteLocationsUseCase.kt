package fr.ippon.trame.location

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetAllFavoriteLocationsUseCase {
    operator fun invoke(): Flow<List<Location>>
}

class DefaultGetAllFavoriteLocationsUseCase @Inject constructor(private val getAllLocations: GetAllLocationsUseCase) :
    GetAllFavoriteLocationsUseCase {
    override fun invoke(): Flow<List<Location>> {
        return getAllLocations().map { it.filter { location -> location.isFavorite } }
    }
}
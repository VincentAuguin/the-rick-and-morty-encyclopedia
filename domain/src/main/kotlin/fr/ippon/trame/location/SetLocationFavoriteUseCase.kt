package fr.ippon.trame.location

import javax.inject.Inject

interface SetLocationFavoriteUseCase {
    suspend operator fun invoke(locationId: String, favorite: Boolean)
}

class DefaultSetLocationFavoriteUseCase @Inject constructor(private val repository: LocationRepository) :
    SetLocationFavoriteUseCase {
    override suspend fun invoke(locationId: String, favorite: Boolean) {
        repository.getById(locationId)?.let { location ->
            repository.update(location.copy(isFavorite = favorite))
        }
    }
}
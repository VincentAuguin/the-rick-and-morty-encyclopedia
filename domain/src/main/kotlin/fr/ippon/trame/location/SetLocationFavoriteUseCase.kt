package fr.ippon.trame.location

import javax.inject.Inject

interface SetLocationFavoriteUseCase {
    operator fun invoke(locationId: String, favorite: Boolean)
}

class DefaultSetLocationFavoriteUseCase @Inject constructor() : SetLocationFavoriteUseCase {
    override fun invoke(locationId: String, favorite: Boolean) {

    }
}
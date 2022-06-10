package fr.ippon.trame.location

import fr.ippon.trame.FavoriteEligible

data class Location(
    val id: String,
    val name: String,
    override val isFavorite: Boolean
) : FavoriteEligible

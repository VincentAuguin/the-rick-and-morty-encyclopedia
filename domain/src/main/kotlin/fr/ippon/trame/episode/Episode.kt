package fr.ippon.trame.episode

import fr.ippon.trame.FavoriteEligible

data class Episode(
    val id: String,
    val name: String,
    val episode: String,
    override val isFavorite: Boolean
): FavoriteEligible

package fr.ippon.trame.location

import fr.ippon.trame.FavoriteEligible

data class Location(
    val id: String,
    val name: String,
    val dimension: String,
    override val isFavorite: Boolean
) : FavoriteEligible {
    override fun equals(other: Any?): Boolean {
        return if (other is Location) {
            id == other.id
        } else super.equals(other)
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + isFavorite.hashCode()
        return result
    }
}

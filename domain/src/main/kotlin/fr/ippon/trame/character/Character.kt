package fr.ippon.trame.character

import fr.ippon.trame.FavoriteEligible

data class Character(
    val id: String,
    val name: String,
    val imageUrl: String,
    override val isFavorite: Boolean,
) : FavoriteEligible {

    override fun equals(other: Any?): Boolean {
        return if (other is Character) {
            id == other.id && isFavorite == other.isFavorite
        } else super.equals(other)
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + imageUrl.hashCode()
        return result
    }
}

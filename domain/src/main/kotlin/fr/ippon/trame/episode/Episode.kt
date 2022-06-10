package fr.ippon.trame.episode

import fr.ippon.trame.FavoriteEligible

data class Episode(
    val id: String,
    val name: String,
    val episode: String,
    override val isFavorite: Boolean
) : FavoriteEligible {
    override fun equals(other: Any?): Boolean {
        return if (other is Episode) {
            id == other.id
        } else super.equals(other)
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + episode.hashCode()
        result = 31 * result + isFavorite.hashCode()
        return result
    }
}

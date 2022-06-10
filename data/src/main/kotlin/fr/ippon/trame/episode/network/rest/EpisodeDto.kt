package fr.ippon.trame.episode.network.rest

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeDto(
    val id: Int,
    val name: String?,
    @SerialName("air_date") val airDate: String?,
    val episode: String?,
    val characters: List<String>?,
    val url: String?,
    val created: String?,
)

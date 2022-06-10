package fr.ippon.trame.location.network.rest

import kotlinx.serialization.Serializable

@Serializable
data class LocationDto(
    val id: Int,
    val name: String?,
    val type: String?,
    val dimension: String?,
    val residents: List<String>?,
    val url: String?,
    val created: String?,
)

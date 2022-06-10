package fr.ippon.trame.shared

import kotlinx.serialization.Serializable

@Serializable
data class PaginatedDto<T>(
    val info: Results,
    val results: List<T>
) {
    @Serializable
    data class Results(
        val count: Int,
        val pages: Int,
        val next: String?,
        val prev: String?,
    )
}

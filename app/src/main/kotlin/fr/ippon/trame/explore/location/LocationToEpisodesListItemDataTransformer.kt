package fr.ippon.trame.explore.location

import fr.ippon.trame.location.Location
import javax.inject.Inject

interface LocationToLocationsListItemDataTransformer {
    operator fun invoke(location: Location): LocationsListItemData
}

class LocationToLocationsListItemDataTransformerImpl @Inject constructor() :
    LocationToLocationsListItemDataTransformer {
    override fun invoke(location: Location): LocationsListItemData {
        val name = StringBuilder(location.name)
            .apply {
                if (location.dimension != "unknown") {
                    append(" ")
                    append("(${location.dimension})")
                }
            }
            .toString()

        return LocationsListItemData(
            id = location.id,
            name = name,
            favorite = location.isFavorite
        )
    }
}
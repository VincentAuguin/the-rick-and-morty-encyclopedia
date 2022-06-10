package fr.ippon.trame.explore.location

import fr.ippon.trame.location.Location
import javax.inject.Inject

interface LocationToLocationsListItemDataTransformer {
    operator fun invoke(location: Location): LocationsListItemData
}

class LocationToLocationsListItemDataTransformerImpl @Inject constructor() :
    LocationToLocationsListItemDataTransformer {
    override fun invoke(location: Location): LocationsListItemData {
        return LocationsListItemData(
            id = location.id,
            name = location.name,
            favorite = location.isFavorite
        )
    }
}
package fr.ippon.trame.explore.location

import fr.ippon.trame.location.Location
import javax.inject.Inject

interface LocationsToLocationsListDataTransformer {
    operator fun invoke(locations: List<Location>): LocationsListData
}

class LocationsToLocationsListDataTransformerImpl @Inject constructor(private val transformToLocationsListItemData: LocationToLocationsListItemDataTransformer) :
    LocationsToLocationsListDataTransformer {
    override fun invoke(locations: List<Location>): LocationsListData {
        return LocationsListData(locations = locations.map(transformToLocationsListItemData::invoke))
    }
}
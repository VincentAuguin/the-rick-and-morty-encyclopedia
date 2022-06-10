package fr.ippon.trame.location

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

interface GetAllLocationsUseCase {
    operator fun invoke(): Flow<List<Location>>
}

class DefaultGetAllLocationsUseCase @Inject constructor() : GetAllLocationsUseCase {
    override fun invoke(): Flow<List<Location>> {
        return flowOf(
            listOf(
                Location(
                    id = "1",
                    name = "Earth (C-137)",
                    isFavorite = true
                ),
                Location(
                    id = "2",
                    name = "Abadango",
                    isFavorite = false
                ),
                Location(
                    id = "3",
                    name = "Citadel of Ricks",
                    isFavorite = true
                ),
            )
        )
    }
}
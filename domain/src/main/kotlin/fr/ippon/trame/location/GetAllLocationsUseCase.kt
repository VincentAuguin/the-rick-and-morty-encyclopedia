package fr.ippon.trame.location

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

interface GetAllLocationsUseCase {
    operator fun invoke(): Flow<List<Location>>
}

class DefaultGetAllLocationsUseCase @Inject constructor(private val repository: LocationRepository) :
    GetAllLocationsUseCase {
    override fun invoke(): Flow<List<Location>> {
        return repository.getAll().distinctUntilChanged()
    }
}
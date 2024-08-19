package ru.potemkin.weatherapp.domain.usecase

import ru.potemkin.weatherapp.domain.repositories.FavouriteRepository
import javax.inject.Inject

class GetFavouriteCitiesUseCase @Inject constructor(
    private val repository: FavouriteRepository
) {

    operator fun invoke() = repository.favouriteCities
}
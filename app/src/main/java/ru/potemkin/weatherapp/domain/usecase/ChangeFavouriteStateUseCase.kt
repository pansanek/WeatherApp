package ru.potemkin.weatherapp.domain.usecase

import ru.potemkin.weatherapp.domain.entity.City
import ru.potemkin.weatherapp.domain.repositories.FavouriteRepository
import javax.inject.Inject

class ChangeFavouriteStateUseCase @Inject constructor(
    private val repository: FavouriteRepository
) {

    suspend fun addToFavourite(city: City) = repository.addToFavourite(city)
    suspend fun removeFromFavourite(cityId: Int) = repository.removeFromFavourite(cityId)
}
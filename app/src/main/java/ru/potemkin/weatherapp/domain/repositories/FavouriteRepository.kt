package ru.potemkin.weatherapp.domain.repositories

import kotlinx.coroutines.flow.Flow
import ru.potemkin.weatherapp.domain.entity.City

interface FavouriteRepository {

    val favouriteCities: Flow<List<City>>

    fun observeIsFavourite(cityId: Int): Flow<Boolean>

    suspend fun addToFavourite(city: City)

    suspend fun removeFromFavourite(cityId: Int)
}
package ru.potemkin.weatherapp.presentation.favourite

import kotlinx.coroutines.flow.StateFlow
import ru.potemkin.weatherapp.domain.entity.City

interface FavouriteComponent {

    val model: StateFlow<FavouriteStore.State>

    fun onClickSearch()

    fun onClickAddFavourite()

    fun onCityItemClick(city: City)
}
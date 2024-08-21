package ru.potemkin.weatherapp.presentation.details

import kotlinx.coroutines.flow.StateFlow
import ru.potemkin.weatherapp.presentation.extensions.componentScope

interface DetailsComponent {
    val model: StateFlow<DetailsStore.State>

    fun onClickBack()

    fun onClickChangeFavouriteStatus()
}
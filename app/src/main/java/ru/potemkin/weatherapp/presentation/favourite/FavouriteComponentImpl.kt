package ru.potemkin.weatherapp.presentation.favourite

import com.arkivanov.decompose.ComponentContext

class FavouriteComponentImpl(
    componentContext: ComponentContext
) : FavouriteComponent,
    ComponentContext by componentContext
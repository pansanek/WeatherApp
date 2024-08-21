package ru.potemkin.weatherapp.presentation.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import ru.potemkin.weatherapp.presentation.details.DetailsComponent
import ru.potemkin.weatherapp.presentation.favourite.FavouriteComponent
import ru.potemkin.weatherapp.presentation.search.SearchComponent

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>
    sealed interface Child{

        data class Favourite(val component:FavouriteComponent) :Child

        data class Search(val component: SearchComponent) :Child

        data class Details(val component: DetailsComponent) :Child
    }
}
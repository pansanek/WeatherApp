package ru.potemkin.weatherapp.presentation.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.parcelize.Parcelize
import ru.potemkin.weatherapp.domain.entity.City
import ru.potemkin.weatherapp.presentation.details.DetailsComponentImpl
import ru.potemkin.weatherapp.presentation.favourite.FavouriteComponentImpl
import ru.potemkin.weatherapp.presentation.search.OpenReason
import ru.potemkin.weatherapp.presentation.search.SearchComponentImpl

class RootComponentImpl @AssistedInject constructor(
    private val detailsComponentFactory: DetailsComponentImpl.Factory,
    private val favouriteComponentFactory: FavouriteComponentImpl.Factory,
    private val searchComponentFactory: SearchComponentImpl.Factory,
    @Assisted("componentContext") componentContext: ComponentContext
) : RootComponent,
    ComponentContext by componentContext {
    override val stack: Value<ChildStack<*, RootComponent.Child>>
        get() = TODO("Not yet implemented")


    private fun child(
        config: Config,
        componentContext: ComponentContext
    ): RootComponent.Child {
        return when (config) {
            is Config.Details -> {
                val component = detailsComponentFactory.create(
                    city = config.city,
                    onBackClicked = {

                    },
                    componentContext = componentContext
                )
                RootComponent.Child.Details(component)
            }
            Config.Favourite -> {
                val component = favouriteComponentFactory.create(
                    onCityItemClicked = {

                    },
                    onAddFavouriteClicked = {

                    },
                    onSearchClicked = {

                    },
                    componentContext = componentContext
                )
                RootComponent.Child.Favourite(component)
            }
            is Config.Search -> {
                val component = searchComponentFactory.create(
                    openReason = config.openReason,
                    onBackClicked = {},
                    onCitySavedToFavourite = {},
                    onForecastForCityRequested = {},
                    componentContext = componentContext
                )
                RootComponent.Child.Search(component)
            }
        }
    }

    sealed interface Config : Parcelable {

        @Parcelize
        data object Favourite : Config

        @Parcelize
        data class Search(val openReason: OpenReason) : Config

        @Parcelize
        data class Details(val city: City) : Config
    }
}
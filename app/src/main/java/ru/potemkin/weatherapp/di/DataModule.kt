package ru.potemkin.weatherapp.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.potemkin.weatherapp.data.local.db.FavouriteCitiesDao
import ru.potemkin.weatherapp.data.local.db.FavouriteDatabase
import ru.potemkin.weatherapp.data.network.api.ApiFactory
import ru.potemkin.weatherapp.data.network.api.ApiService
import ru.potemkin.weatherapp.data.repositories.FavouriteRepositoryImpl
import ru.potemkin.weatherapp.data.repositories.SearchRepositoryImpl
import ru.potemkin.weatherapp.data.repositories.WeatherRepositoryImpl
import ru.potemkin.weatherapp.domain.repositories.FavouriteRepository
import ru.potemkin.weatherapp.domain.repositories.SearchRepository
import ru.potemkin.weatherapp.domain.repositories.WeatherRepository

@Module
interface DataModule {

    @[ApplicationScope Binds]
    fun bindFavouriteRepository(impl: FavouriteRepositoryImpl): FavouriteRepository

    @[ApplicationScope Binds]
    fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

    @[ApplicationScope Binds]
    fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository

    companion object {

        @[ApplicationScope Provides]
        fun provideApiService(): ApiService = ApiFactory.apiService

        @[ApplicationScope Provides]
        fun provideFavouriteDatabase(context: Context): FavouriteDatabase {
            return FavouriteDatabase.getInstance(context)
        }

        @[ApplicationScope Provides]
        fun provideFavouriteCitiesDao(database: FavouriteDatabase): FavouriteCitiesDao {
            return database.favouriteCitiesDao()
        }
    }
}
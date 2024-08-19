package ru.potemkin.weatherapp.domain.repositories

import ru.potemkin.weatherapp.domain.entity.Forecast
import ru.potemkin.weatherapp.domain.entity.Weather

interface WeatherRepository {

    suspend fun getWeather(cityId: Int): Weather

    suspend fun getForecast(cityId: Int): Forecast
}
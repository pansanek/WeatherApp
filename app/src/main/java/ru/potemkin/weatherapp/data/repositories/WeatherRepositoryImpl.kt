package ru.potemkin.weatherapp.data.repositories

import ru.potemkin.weatherapp.data.mapper.toEntity
import ru.potemkin.weatherapp.data.network.api.ApiService
import ru.potemkin.weatherapp.domain.entity.Forecast
import ru.potemkin.weatherapp.domain.entity.Weather
import ru.potemkin.weatherapp.domain.repositories.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : WeatherRepository {
    override suspend fun getWeather(cityId: Int): Weather {
        return apiService.loadCurrentWeather("$PREFIX_CITY_ID$cityId").toEntity()
    }

    override suspend fun getForecast(cityId: Int): Forecast {
        return apiService.loadForecast("$PREFIX_CITY_ID$cityId").toEntity()
    }

    private companion object {

        private const val PREFIX_CITY_ID = "id:"
    }
}
package ru.potemkin.weatherapp.data.network.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.potemkin.weatherapp.data.network.dto.CityDto
import ru.potemkin.weatherapp.data.network.dto.WeatherCurrentDto
import ru.potemkin.weatherapp.data.network.dto.WeatherForecastDto

interface ApiService {


    @GET("current.json?key=")
    suspend fun loadCurrentWeather(
        @Query("q") query: String
    ): WeatherCurrentDto

    @GET("forecast.json?key=")
    suspend fun loadForecast(
        @Query("q") query: String,
        @Query("days") daysCount: Int = 4
    ): WeatherForecastDto

    @GET("search.json?key=")
    suspend fun searchCity(
        @Query("q") query: String
    ): List<CityDto>
}
package ru.potemkin.weatherapp.domain.usecase

import ru.potemkin.weatherapp.domain.repositories.WeatherRepository
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(cityId: Int) = repository.getWeather(cityId)
}
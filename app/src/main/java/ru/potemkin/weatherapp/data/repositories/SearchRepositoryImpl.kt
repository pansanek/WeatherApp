package ru.potemkin.weatherapp.data.repositories

import ru.potemkin.weatherapp.data.mapper.toEntities
import ru.potemkin.weatherapp.data.network.api.ApiService
import ru.potemkin.weatherapp.domain.entity.City
import ru.potemkin.weatherapp.domain.repositories.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : SearchRepository {
    override suspend fun search(query: String): List<City> {
        return apiService.searchCity(query).toEntities()
    }
}
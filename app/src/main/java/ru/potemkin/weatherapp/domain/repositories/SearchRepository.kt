package ru.potemkin.weatherapp.domain.repositories

import ru.potemkin.weatherapp.domain.entity.City

interface SearchRepository {

    suspend fun search(query: String): List<City>
}
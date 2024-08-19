package ru.potemkin.weatherapp.domain.usecase

import ru.potemkin.weatherapp.domain.repositories.SearchRepository
import javax.inject.Inject

class SearchCityUseCase @Inject constructor(
    private val repository: SearchRepository
) {

    suspend operator fun invoke(query: String) = repository.search(query)
}
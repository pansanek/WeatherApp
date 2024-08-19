package ru.potemkin.weatherapp.data.mapper

import ru.potemkin.weatherapp.data.network.dto.CityDto
import ru.potemkin.weatherapp.domain.entity.City

fun CityDto.toEntity(): City = City(id, name, country)

fun List<CityDto>.toEntities(): List<City> = map { it.toEntity() }
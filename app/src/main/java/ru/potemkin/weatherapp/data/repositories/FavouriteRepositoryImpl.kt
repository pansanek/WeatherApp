package ru.potemkin.weatherapp.data.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.potemkin.weatherapp.data.local.db.FavouriteCitiesDao
import ru.potemkin.weatherapp.data.mapper.toDbModel
import ru.potemkin.weatherapp.data.mapper.toEntities
import ru.potemkin.weatherapp.domain.entity.City
import ru.potemkin.weatherapp.domain.repositories.FavouriteRepository
import javax.inject.Inject

class FavouriteRepositoryImpl @Inject constructor(
    private val favouriteCitiesDao: FavouriteCitiesDao
) : FavouriteRepository {
    override val favouriteCities: Flow<List<City>> = favouriteCitiesDao.getFavouriteCities().map {
        it.toEntities()
    }

    override fun observeIsFavourite(cityId: Int): Flow<Boolean> =
        favouriteCitiesDao.observeIsFavourite(cityId)

    override suspend fun addToFavourite(city: City) {
        favouriteCitiesDao.addToFavourite(city.toDbModel())
    }

    override suspend fun removeFromFavourite(cityId: Int) {
        favouriteCitiesDao.removeFromFavourite(cityId)
    }
}
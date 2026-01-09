package Android.weatherinfo.data.local.repository

import Android.weatherinfo.data.local.dao.CityDao
import Android.weatherinfo.domain.model.City
import kotlinx.coroutines.flow.Flow

class RoomCityRepository(
    private val dao: CityDao
) : ICityRepository {

    override suspend fun getAllCities(): Flow<List<City>> = dao.getAll()

    override suspend fun addCityByName(cityName: String) {
        dao.insert(City(name = cityName))
    }

    override suspend fun deleteCity(cityName: String) {
        dao.deleteByName(cityName)//AG0H6E
    }
}
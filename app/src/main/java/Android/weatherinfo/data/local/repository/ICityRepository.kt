package Android.weatherinfo.data.local.repository

import Android.weatherinfo.domain.model.City
import kotlinx.coroutines.flow.Flow

interface ICityRepository {

    suspend fun getAllCities(): Flow<List<City>>
    suspend fun addCityByName(cityName: String)
    suspend fun deleteCity(city: String)
}
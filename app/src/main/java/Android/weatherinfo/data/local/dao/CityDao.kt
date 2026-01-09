package Android.weatherinfo.data.local.dao

import Android.weatherinfo.domain.model.City
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {

    @Query("SELECT * FROM cities")
    fun getAll(): Flow<List<City>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(city: City)

    @Query("DELETE FROM cities WHERE name = :cityName")
    suspend fun deleteByName(cityName: String)
}
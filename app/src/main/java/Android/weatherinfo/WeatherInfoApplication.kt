package Android.weatherinfo


import Android.weatherinfo.data.local.database.CityDatabase
import Android.weatherinfo.data.local.repository.ICityRepository
import Android.weatherinfo.data.local.repository.RoomCityRepository
import Android.weatherinfo.data.network.repository.IWeatherRepository
import Android.weatherinfo.data.network.repository.RetrofitWeatherRepository
import android.app.Application

class WeatherInfoApplication : Application() {
    companion object {

        lateinit var weatherRepository: IWeatherRepository
        lateinit var cityRepository: ICityRepository
    }

    override fun onCreate() {
        super.onCreate()

        weatherRepository = RetrofitWeatherRepository()
        val database = CityDatabase.getDatabase(this)
        cityRepository = RoomCityRepository(database.cityDao())
    }
}

package Android.weatherinfo.ui.screen.weather.state

import Android.weatherinfo.data.network.model.WeatherData

sealed class WeatherScreenState{
    data object Loading: WeatherScreenState()
    data class Error(val error: Throwable): WeatherScreenState()
    data class Success(val weatherData: WeatherData?): WeatherScreenState()
}
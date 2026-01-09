package Android.weatherinfo.ui.screen.citylist.state

import Android.weatherinfo.domain.model.City


sealed class CityListScreenState {
    data object Loading : CityListScreenState()
    data class Error(val error: Throwable) : CityListScreenState()
    data class Result(val cityList: List<City>) : CityListScreenState()
}

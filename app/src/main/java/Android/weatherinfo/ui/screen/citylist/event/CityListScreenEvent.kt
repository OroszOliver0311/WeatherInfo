package Android.weatherinfo.ui.screen.citylist.event

sealed class CityListScreenEvent {
    data class CityCreated(val city: String) : CityListScreenEvent()
    data class CityDeleted(val city: String) : CityListScreenEvent()
}

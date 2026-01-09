package Android.weatherinfo.ui.screen.citylist


import Android.weatherinfo.WeatherInfoApplication
import Android.weatherinfo.data.local.repository.ICityRepository
import Android.weatherinfo.ui.screen.citylist.event.CityListScreenEvent
import Android.weatherinfo.ui.screen.citylist.state.CityListScreenState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CityListViewModel(
    private val cityRepository: ICityRepository
) : ViewModel() {

    private val _state = MutableStateFlow<CityListScreenState>(CityListScreenState.Loading)
    val state = _state.asStateFlow()

    init {
        getAllCities()
    }

    private fun getAllCities() {
        viewModelScope.launch {
            _state.value = CityListScreenState.Loading
            try {
                cityRepository.getAllCities().collectLatest {
                    _state.tryEmit(CityListScreenState.Result(it))
                }
            } catch (e: Exception) {
                _state.value = CityListScreenState.Error(e)
            }


        }
    }
    fun onEvent(event: CityListScreenEvent) {
        when (event) {
            is CityListScreenEvent.CityCreated ->
                addCity(event.city)
            is CityListScreenEvent.CityDeleted ->
                deleteCity(event.city)
        }
    }
    private fun addCity(city: String) {
        viewModelScope.launch {
            try {
                cityRepository.addCityByName(city)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    private fun deleteCity(city: String) {
        viewModelScope.launch {
            try {
                cityRepository.deleteCity(city)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                CityListViewModel(
                    cityRepository = WeatherInfoApplication.cityRepository
                )
            }
        }
    }
}

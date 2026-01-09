package Android.weatherinfo.ui.navigation

import Android.weatherinfo.ui.screen.citylist.CityListScreen
import Android.weatherinfo.ui.screen.weather.WeatherScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(Screen.CityListScreenDestination)

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {

            entry<Screen.CityListScreenDestination> {
                CityListScreen(
                    modifier = modifier,
                    onCityClick = { backStack.add(Screen.WeatherScreenDestination(cityName = it)) }
                )
            }

            entry<Screen.WeatherScreenDestination> { key ->
                WeatherScreen(
                    modifier = modifier,
                    cityName = key.cityName,
                    onNavigateBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}
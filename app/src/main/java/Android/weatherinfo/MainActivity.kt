package Android.weatherinfo

import Android.weatherinfo.ui.navigation.AppNavigation
import Android.weatherinfo.ui.theme.WeatherInfoTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherInfoTheme {
                AppNavigation(modifier = Modifier.safeDrawingPadding())
            }
        }
    }
}
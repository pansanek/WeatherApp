package ru.potemkin.weatherapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.potemkin.weatherapp.WeatherApp
import ru.potemkin.weatherapp.data.network.api.ApiFactory
import ru.potemkin.weatherapp.presentation.root.RootComponentImpl
import ru.potemkin.weatherapp.presentation.root.RootContent
import ru.potemkin.weatherapp.presentation.ui.theme.WeatherAppTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var rootComponentFactory: RootComponentImpl.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as WeatherApp).applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RootContent(component =rootComponentFactory.create(defaultComponentContext()) )
        }
    }
}

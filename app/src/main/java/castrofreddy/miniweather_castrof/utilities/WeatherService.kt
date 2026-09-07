package castrofreddy.miniweather_castrof.utilities

import android.content.Context
import castrofreddy.miniweather_castrof.R
import castrofreddy.miniweather_castrof.domain.Weather

class WeatherService(private val context: Context) {

    val weatherStates = arrayOf(
        context.getString(R.string.snowy),
        context.getString(R.string.windy),
        context.getString(R.string.stormy),
        context.getString(R.string.rainy),
        context.getString(R.string.cloudy),
        context.getString(R.string.sunny)
    )

    fun getCities(): Array<String>{
        return arrayOf(
            "Ciudad de Mexico",
            "Londres",
            "Paris",
            "Guadalajara",
            "Ciudad Obregon",
            "Guasave"
        )
    }

    fun getWeather(city: String): Weather {
        return generateWeather()
    }

    private fun generateWeather(): Weather{
        val temp = (-15..50).random()
        var weatherIndex = -1
        when(temp){
            in -15..0 -> weatherIndex = 0
            in 1..18 -> weatherIndex = (1..4).random()
            in 19..25 -> weatherIndex = (4..5).random()
            else -> weatherIndex = 5
        }
        return Weather(temperature = temp,
            weatherStates[weatherIndex])
    }

}
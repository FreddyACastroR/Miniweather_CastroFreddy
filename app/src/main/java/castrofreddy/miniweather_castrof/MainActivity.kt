package castrofreddy.miniweather_castrof

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView
import android.widget.TextView
import castrofreddy.miniweather_castrof.domain.Weather
import castrofreddy.miniweather_castrof.utilities.WeatherService
import java.time.LocalTime

class MainActivity : AppCompatActivity() {

    private lateinit var tvGreeting: TextView
    private lateinit var tvCity: TextView
    private lateinit var ivWeather: ImageView
    private lateinit var tvTemperature: TextView
    private lateinit var tvWeather: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tvGreeting = findViewById(R.id.tvGreeting)

        tvCity = findViewById(R.id.tvCity)

        ivWeather = findViewById(R.id.ivWeather)

        tvTemperature = findViewById(R.id.tvTemperature)

        tvWeather = findViewById(R.id.tvWeather)

        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = false

        val citySelected = intent.getStringExtra("city") ?: ""

        val service = WeatherService(this)
        val weather: Weather = service.getWeather(citySelected)

        tvCity.text = citySelected
        tvTemperature.text = "${weather.temperature}°C"
        tvWeather.text = weather.weather
        ivWeather.setImageResource(getWeatherIcon(weather.weather))
    }

    override fun onResume() {
        super.onResume()
        updateGreeting()
    }
    private fun updateGreeting() {
        val time = LocalTime.now().hour
        val greeting = when (time) {
            in 5..11 -> getString(R.string.good_morning)
            in 12..19 -> getString(R.string.good_afternoon)
            else -> getString(R.string.good_evening)
        }
        tvGreeting.text = greeting
    }

    private fun getWeatherIcon(weather: String): Int {
        return when (weather) {
            getString(R.string.snowy) -> R.drawable.ic_snowy
            getString(R.string.windy) -> R.drawable.ic_windy
            getString(R.string.stormy) -> R.drawable.ic_stormy
            getString(R.string.rainy) -> R.drawable.ic_rainy
            getString(R.string.cloudy) -> R.drawable.ic_cloudy
            else -> R.drawable.ic_sunny
        }
    }
}
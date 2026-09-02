package castrofreddy.miniweather_castrof

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView
import android.widget.TextView

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btn_save_city)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tvGreeting = findViewById(R.id.tvGreeting)

        tvCity = findViewById(R.id.tvCity)

        ivWeather = findViewById(R.id.ivWeather)

        tvTemperature = findViewById(R.id.tvTemperature)

        tvWeather = findViewById(R.id.tvWeather)
    }
}
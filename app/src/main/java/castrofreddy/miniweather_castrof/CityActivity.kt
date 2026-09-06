package castrofreddy.miniweather_castrof

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import castrofreddy.miniweather_castrof.utilities.WeatherService

class CityActivity : AppCompatActivity() {

    var citySelected: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_city)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btn_save_city)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val service: WeatherService = WeatherService(this)
        val citySelector: Spinner = findViewById<Spinner>(R.id.city_selector)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,
            service.getCities()
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        citySelector.adapter = adapter

        citySelector.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                citySelected = parent!!.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val buttonNext = findViewById<Button>(R.id.btn_save_city)
        buttonNext.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("city", citySelected)
            }
            startActivity(intent)
        }

    }
}
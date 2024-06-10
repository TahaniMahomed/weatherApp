package com.example.weatherapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat




    class MainActivity3 : AppCompatActivity() {

        private lateinit var temperatureInputs: DoubleArray
        private lateinit var backButton: Button
        private lateinit var temperatureTextView: TextView
        private lateinit var averageTemperatureTextView: TextView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_main3)

            backButton = findViewById(R.id.backButton)
            temperatureTextView = findViewById(R.id.temperatureTextView)
            averageTemperatureTextView = findViewById(R.id.averageTemperatureTextView)

            // Fetch temperatureInputs from intent (only once)
            temperatureInputs = intent.getDoubleArrayExtra("screen_times") ?: DoubleArray(7)


            displayDetails()

            backButton.setOnClickListener {
                finish()
            }
        }

        private fun displayDetails() {
            val days = arrayOf(
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
            )


            temperatureTextView.text = buildString {
                // Use the actual temperatureInputs array
                for (i in temperatureInputs.indices) {
                    append("${days[i]}: ${temperatureInputs[i]}°C\n")
                }
            }

            val averageTemperature = temperatureInputs.average()
            averageTemperatureTextView.text =
                "Average Screen Time: %.2f hours/day".format(averageTemperature)
        }
    }



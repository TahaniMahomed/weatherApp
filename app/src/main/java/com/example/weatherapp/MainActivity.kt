package com.example.weatherapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login {

}

class MainActivity : AppCompatActivity() {

    private lateinit var nextButton: Button
    private lateinit var exitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextButton = findViewById(R.id.nextButton)
        exitButton = findViewById(R.id.exitButton)

        nextButton.setOnClickListener {
            // Handle edge-to-edge after setting content view (if applicable)
            enableEdgeToEdge()

            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                finish() // Close the splash screen activity
            }, 3000) // 3000 milliseconds (3 seconds) delay

        }
        // ... (Your enableEdgeToEdge() function if needed)

        exitButton.setOnClickListener {
            finish()
        }

    }


}























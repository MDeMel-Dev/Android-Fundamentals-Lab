package com.mdemel.afl.HomeScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mdemel.afl.R
import com.mdemel.afl.SecondScreen.InfoActivity

class MainActivity : AppCompatActivity() {
    lateinit private var navigateButton: Button

    val intentToNavigateToInfoScreen = Intent(this, InfoActivity::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateButton = findViewById(R.id.navigateButtonToInfo)

        navigateButton.setOnClickListener {
            startActivity(intentToNavigateToInfoScreen)
        }
    }
}
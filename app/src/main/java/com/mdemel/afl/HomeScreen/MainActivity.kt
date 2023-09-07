package com.mdemel.afl.HomeScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mdemel.afl.R

class MainActivity : AppCompatActivity() {
    lateinit private var navigateButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateButton = findViewById(R.id.navigateButtonToInfo)
    }
}
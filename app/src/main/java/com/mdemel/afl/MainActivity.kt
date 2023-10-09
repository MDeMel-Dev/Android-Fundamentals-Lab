package com.mdemel.afl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    private var button: AppCompatButton? = null

    private val intentToNavigateToSecondScreen by lazy {
        Intent(this, SecondScreenActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.buttonHomeScreen) as? AppCompatButton

        button?.setOnClickListener {
            Log.d("MelbClass", "Button clicked ")

            startActivity(intentToNavigateToSecondScreen)
        }
    }
}
package com.mdemel.afl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton

class ThirdScreenActivity : AppCompatActivity() {
    private var button: AppCompatButton? = null

    private val intentToNavigateToHomeScreen by lazy {
        Intent(this, MainActivity::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_screen)

        button = findViewById(R.id.buttonThirdScreen) as? AppCompatButton

        button?.setOnClickListener {
            Log.d("MelbClass", "Third Screen Button clicked ")
            startActivity(intentToNavigateToHomeScreen)
        }
    }
}
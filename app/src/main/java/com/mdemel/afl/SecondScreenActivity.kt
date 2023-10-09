package com.mdemel.afl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton

class SecondScreenActivity : AppCompatActivity() {

    private var button: AppCompatButton? = null

    private val intentToNavigateToThirdScreen by lazy {
        Intent(this, ThirdScreenActivity::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        button = findViewById(R.id.buttonSecondScreen) as? AppCompatButton

        button?.setOnClickListener {
            Log.d("MelbClass", "Second Screen Button clicked ")

            startActivity(intentToNavigateToThirdScreen)
        }
    }
}
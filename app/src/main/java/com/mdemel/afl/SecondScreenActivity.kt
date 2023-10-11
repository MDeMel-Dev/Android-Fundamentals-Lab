package com.mdemel.afl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

class SecondScreenActivity : AppCompatActivity() {

    private var button: AppCompatButton? = null
    private var topTextLabel: AppCompatTextView? = null

    private val intentToNavigateToThirdScreen by lazy {
        Intent(this, ThirdScreenActivity::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        button = findViewById(R.id.buttonSecondScreen) as? AppCompatButton
        topTextLabel = findViewById(R.id.toptext) as? AppCompatTextView

        // Syntax to retrieve data from your intents
        topTextLabel?.text = intent.getStringExtra("key1") ?: "No Data"

        button?.setOnClickListener {
            Log.d("MelbClass", "Second Screen Button clicked ")

            startActivity(intentToNavigateToThirdScreen)
        }
    }
}
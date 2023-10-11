package com.mdemel.afl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.mdemel.afl.models.HomeScreenData

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

        // Syntax to retrieve a dataClass from your intents
        (intent.extras?.get("key1") as? HomeScreenData).let {data ->
                topTextLabel?.text = data?.textValue + " " + data?.numberValue
        }

        button?.setOnClickListener {
            Log.d("MelbClass", "Second Screen Button clicked ")

            startActivity(intentToNavigateToThirdScreen)
        }
    }
}
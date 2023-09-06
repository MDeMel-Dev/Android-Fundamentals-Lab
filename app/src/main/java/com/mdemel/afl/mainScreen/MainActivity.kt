package com.mdemel.afl.mainScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mdemel.afl.R
import com.mdemel.afl.secondScreen.SecondActivity

class MainActivity : AppCompatActivity() {

    val intentToSecondScreen = Intent(this, SecondActivity::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonToNavigateToSecondScreen = findViewById<Button>(R.id.navigateButton)

        buttonToNavigateToSecondScreen.setOnClickListener {

            startActivity(intentToSecondScreen)
        }
    }
}
package com.mdemel.afl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    // How to create a liveData
    private var exampleLiveData = MutableLiveData("Initial value")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        exampleLiveData.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }

        findViewById<AppCompatButton>(R.id.asyncWorkButton).setOnClickListener {
            // How to create a new thread
            CoroutineScope(Dispatchers.Main).launch {

                delay(5000)
                // <-- imagine 5 seconds worth logic here
                // Now it's 5 seconds after
                exampleLiveData.value = "New value after 5 mins"
            }
        }
    }
}


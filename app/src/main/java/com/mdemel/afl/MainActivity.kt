package com.mdemel.afl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.widget.addTextChangedListener
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    private var userName = ""
    private var password = ""

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://catfact.ninja") // Add the correct base url
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<EditText>(R.id.userNameInput).addTextChangedListener {
            userName = it.toString()
        }

        findViewById<EditText>(R.id.passwordInput).addTextChangedListener {
            password = it.toString()
        }

        findViewById<Button>(R.id.buttonLogin).setOnClickListener {
            // retrofit call here
        }
    }
}
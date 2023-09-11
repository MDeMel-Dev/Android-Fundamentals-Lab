package com.mdemel.afl.HomeScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.google.gson.Gson
import com.mdemel.afl.R
import com.mdemel.afl.SecondScreen.InfoActivity
import com.mdemel.afl.network.services.EntriesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit private var navigateButton: Button
    lateinit private var textCollectionForm: EditText

    var textHolder = ""

    val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.publicapis.org").addConverterFactory(
        GsonConverterFactory.create()).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentToNavigateToInfoScreen = Intent(this, InfoActivity::class.java)

        // Get references to the views in our layout file
        navigateButton = findViewById(R.id.navigateButtonToInfo)
        textCollectionForm = findViewById(R.id.textCollectForm)

        // set click listners/callbacks
        navigateButton.setOnClickListener {
            startActivity(intentToNavigateToInfoScreen)
        }

        textCollectionForm.addTextChangedListener {
            textHolder = it.toString()
        }

        val entriesApiService: EntriesService = retrofit.create<EntriesService>()

        val entriesList = entriesApiService.getEntries()
    }
}
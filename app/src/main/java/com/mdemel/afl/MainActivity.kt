package com.mdemel.afl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(MainScreenViewModel::class.java)
    }

    private val textLabel: TextView by lazy {
        findViewById(R.id.textView)
    }

    private val buttonGetCatFact: AppCompatButton by lazy {
        findViewById(R.id.buttonGetCatFact)
    }

    private val buttonGetDogImage: AppCompatButton by lazy {
        findViewById(R.id.buttonGetDogImage)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.catFactResponseLiveData.observe(this) { response ->
            textLabel.text = response?.fact ?: "Hello World\nWelcome to the world of\nCat Facts"
        }

        viewModel.dogImageResponseLiveData.observe(this) { response ->
            
        }

        buttonGetCatFact.setOnClickListener {
            viewModel.executeGetCatFactCall()
        }

        buttonGetDogImage.setOnClickListener {
            viewModel.executeGetDogImageCall()
        }
    }
}
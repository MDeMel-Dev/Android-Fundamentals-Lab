package com.mdemel.afl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide

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

    private val dogImage: ImageView by lazy {
        findViewById(R.id.dogImage)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.catFactResponseLiveData.observe(this) { response ->
            textLabel.text = response?.fact ?: "Hello World\nWelcome to the world of\nCat Facts and Dog Images."
        }

        viewModel.dogImageResponseLiveData.observe(this) { response ->
            Glide.with(this)
                .load(response?.message)
                .into(dogImage)
        }

        buttonGetCatFact.setOnClickListener {
            viewModel.executeGetCatFactCall()
        }

        buttonGetDogImage.setOnClickListener {
            viewModel.executeGetDogImageCall()
        }
    }
}
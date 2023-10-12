package com.mdemel.afl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mdemel.afl.api.CatFactApi
import com.mdemel.afl.model.CatFactResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(MainScreenViewModel::class.java)
    }

    private val textLabel: TextView by lazy {
        findViewById(R.id.textView)
    }

    private val button: AppCompatButton by lazy {
        findViewById(R.id.buttonGetFact)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.responseLiveData.observe(this) { response ->
            textLabel.text = response?.fact ?: "Hello World\nWelcome to the world of\nCat Facts"
        }

        button.setOnClickListener {
            viewModel.executeGetCatFactCall()
        }
    }
}
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
import com.mdemel.afl.api.CatFactApi
import com.mdemel.afl.model.CatFactResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    private val textLabel: TextView by lazy {
        findViewById(R.id.textView)
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://catfact.ninja") // Add the correct base url
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private val responseLiveData = MutableLiveData<CatFactResponse?>(null)

    private val button: AppCompatButton by lazy {
        findViewById(R.id.buttonGetFact)
    }

    private val catFactApi: CatFactApi by lazy {
        retrofit.create(CatFactApi::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        responseLiveData.observe(this) { response ->
            textLabel.text = response?.fact ?: "Hello World\nWelcome to the world of\nCat Facts"
        }

        button.setOnClickListener {
            executeGetCatFactCall()
        }
    }

    fun executeGetCatFactCall() {
        CoroutineScope(Dispatchers.Main).launch {
            responseLiveData.value = catFactApi.getCatFact()
        }
    }
}
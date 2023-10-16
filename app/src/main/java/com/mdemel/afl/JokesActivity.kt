package com.mdemel.afl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import com.mdemel.afl.api.JokesApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class JokesActivity : AppCompatActivity() {

    private val jokesListTextView: TextView by lazy {
        findViewById(R.id.jokesList)
    }

    private val retrofitObject by lazy {
            Retrofit.Builder()
                .baseUrl("https://9e22-59-102-79-143.ngrok-free.app") // Add the correct base url
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }

    private val jokesLiveData = MutableLiveData<List<String>?>(null)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jokes)

        val api = retrofitObject.create(JokesApi::class.java)

        jokesLiveData.observe(this) { result ->
            result?.let { jokes ->
                jokesListTextView.text = jokes.toString()
            }
        }

        CoroutineScope(Dispatchers.Main).launch {
            jokesLiveData.value = api.getJokes()
        }
    }
}
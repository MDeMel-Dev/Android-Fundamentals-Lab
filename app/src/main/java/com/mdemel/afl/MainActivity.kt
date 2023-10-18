package com.mdemel.afl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    private var userName = ""
    private var password = ""

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://83e7-103-192-80-150.ngrok-free.app") // Add the correct base url
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private val loginApi: LoginApi by lazy {
        retrofit.create(LoginApi::class.java)
    }

    private val loginResponseLiveData = MutableLiveData<LoginResponse?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginResponseLiveData.observe(this) {
            it?.let { response ->
                Toast.makeText(this, "${response.message}", Toast.LENGTH_LONG).show()
            }
        }

        findViewById<EditText>(R.id.userNameInput).addTextChangedListener {
            userName = it.toString()
        }

        findViewById<EditText>(R.id.passwordInput).addTextChangedListener {
            password = it.toString()
        }

        findViewById<Button>(R.id.buttonLogin).setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                try {
                  loginResponseLiveData.value =  loginApi.login(username = userName, password = password)
                } catch (e: Exception) {
                    loginResponseLiveData.value = LoginResponse(message = "Network call failed $e")
                }

            }
        }
    }
}
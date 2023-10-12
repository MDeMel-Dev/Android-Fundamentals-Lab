package com.mdemel.afl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mdemel.afl.api.CatFactApi
import com.mdemel.afl.model.CatFactResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainScreenViewModel: ViewModel() {

    val responseLiveData = MutableLiveData<CatFactResponse?>(null)

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://catfact.ninja") // Add the correct base url
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val catFactApi: CatFactApi by lazy {
        retrofit.create(CatFactApi::class.java)
    }

    fun executeGetCatFactCall() {
        CoroutineScope(Dispatchers.Main).launch {
            responseLiveData.value = catFactApi.getCatFact()
        }
    }
}
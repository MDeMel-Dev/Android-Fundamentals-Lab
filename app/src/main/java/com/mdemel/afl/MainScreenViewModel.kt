package com.mdemel.afl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mdemel.afl.api.CatFactApi
import com.mdemel.afl.api.DogImageApi
import com.mdemel.afl.model.CatFactResponse
import com.mdemel.afl.model.DogImageResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainScreenViewModel: ViewModel() {

    val catFactResponseLiveData = MutableLiveData<CatFactResponse?>(null)

    val dogImageResponseLiveData = MutableLiveData<DogImageResponse?>(null)

    val catFactsRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://catfact.ninja") // Add the correct base url
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val catFactApi: CatFactApi by lazy {
        catFactsRetrofit.create(CatFactApi::class.java)
    }

    fun executeGetCatFactCall() {
        CoroutineScope(Dispatchers.Main).launch {
            catFactResponseLiveData.value = catFactApi.getCatFact()
        }
    }

    /////////////////////////////// Get Dog Image Logic

    val dogImageRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://dog.ceo") // Add the correct base url for dog image api ( https://dog.ceo/dog-api/ )
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val dogImageApi: DogImageApi by lazy {
        dogImageRetrofit.create(DogImageApi::class.java)
    }

    fun executeGetDogImageCall() {
        CoroutineScope(Dispatchers.Main).launch {
            dogImageResponseLiveData.value = dogImageApi.getDogImage()
        }
    }
}
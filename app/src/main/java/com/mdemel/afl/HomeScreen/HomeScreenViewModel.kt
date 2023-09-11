package com.mdemel.afl.HomeScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mdemel.afl.network.services.EntriesService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class HomeScreenViewModel: ViewModel() {

    val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.publicapis.org").addConverterFactory(
        GsonConverterFactory.create()).build()

    val stringList: MutableLiveData<List<String>>? = MutableLiveData(emptyList())

    init {
        stringList?.value = listOf("a", "b", "c")

        stringList?.value = listOf("x", "y", "z")

        CoroutineScope(Dispatchers.Main).launch {
            val entriesList = entriesApiService.getEntries()

            stringList?.value = entriesList.entries.map {
                it.API
            }
        }
    }

    val entriesApiService: EntriesService = retrofit.create<EntriesService>()
}
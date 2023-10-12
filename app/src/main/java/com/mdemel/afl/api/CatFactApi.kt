package com.mdemel.afl.api

import com.mdemel.afl.model.CatFactResponse
import retrofit2.http.GET

interface CatFactApi {
    @GET("fact")
    suspend fun getCatFact(): CatFactResponse
}
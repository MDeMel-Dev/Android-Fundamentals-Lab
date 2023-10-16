package com.mdemel.afl.api

import retrofit2.http.GET

interface JokesApi {

    @GET("api/jokes")
    suspend fun getJokes(): List<String>
}
package com.mdemel.afl.api

import com.mdemel.afl.model.JokesList
import retrofit2.http.GET

interface JokesApi {

    @GET("api/jokes")
    suspend fun getJokes(): JokesList
}
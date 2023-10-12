package com.mdemel.afl.api

import com.mdemel.afl.model.DogImageResponse
import retrofit2.http.GET

interface DogImageApi {

    @GET("api/breeds/image/random")
    suspend fun getDogImage(): DogImageResponse
}
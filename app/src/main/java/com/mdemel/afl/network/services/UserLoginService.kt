package com.mdemel.afl.network.services

import com.mdemel.afl.network.model.EntriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserLoginService {

    @GET("user")
    suspend fun authenticate(
        @Query(value = "username" ) user: String,
        @Query(value = "password") pswd: String
    ): String
}
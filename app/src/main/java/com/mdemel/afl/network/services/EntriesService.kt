package com.mdemel.afl.network.services

import com.mdemel.afl.network.model.EntriesResponse
import retrofit2.http.GET

interface EntriesService {

    @GET("entries")
    suspend fun getEntries(): EntriesResponse
}
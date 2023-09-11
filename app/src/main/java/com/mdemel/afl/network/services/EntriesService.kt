package com.mdemel.afl.network.services

import com.mdemel.afl.network.model.EntriesResponse
import retrofit2.http.GET

interface EntriesService {

    @GET("entries")
    fun getEntries(): EntriesResponse
}
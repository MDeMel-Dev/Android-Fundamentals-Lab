package com.mdemel.afl.network.model

data class EntriesResponse(
    val count: Int,
    val entries: List<Entry>
)
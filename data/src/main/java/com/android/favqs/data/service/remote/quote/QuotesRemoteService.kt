package com.android.favqs.data.service.remote.quote

import com.android.favqs.data.source.quotes.models.QuotePaginationRemoteData
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesRemoteService {
    @GET("quotes")
    suspend fun getQuotes(
        @Query("filter") login: String,
        @Query("type") type: String
    ): QuotePaginationRemoteData
}
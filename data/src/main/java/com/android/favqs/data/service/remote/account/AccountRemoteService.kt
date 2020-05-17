package com.android.favqs.data.service.remote.account

import com.android.favqs.data.source.account.models.AccountSessionRemoteData
import com.android.favqs.data.source.account.models.params.AccountLoginParamsData
import retrofit2.http.Body
import retrofit2.http.POST

interface AccountRemoteService {
    @POST("session")
    suspend fun loginUser(@Body params: AccountLoginParamsData): AccountSessionRemoteData
}
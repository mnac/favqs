package com.android.favqs.data.service.remote.account

import com.android.favqs.data.source.account.models.AccountSessionRemoteData
import com.android.favqs.data.source.account.models.AccountUserRemoteData
import com.android.favqs.data.source.account.models.params.AccountLoginParamsData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AccountRemoteService {
    @POST("session")
    suspend fun loginAccount(@Body params: AccountLoginParamsData): AccountSessionRemoteData

    @GET("users/{login}")
    suspend fun getAccount(@Path("login") login: String): AccountUserRemoteData
}
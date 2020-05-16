package com.android.favqs.data.remote.account

import com.android.favqs.data.remote.account.models.AccountLoginRemoteData
import com.android.favqs.data.remote.account.models.params.AccountLoginParamsData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AccountApiService {
    @POST("/api/session")
    fun loginUser(@Body params: AccountLoginParamsData): Call<AccountLoginRemoteData>
}
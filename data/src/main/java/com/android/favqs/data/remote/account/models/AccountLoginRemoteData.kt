package com.android.favqs.data.remote.account.models

import com.android.favqs.domain.models.account.AccountToken
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AccountLoginRemoteData(
    @SerializedName("User-Token") val token: String,
    val login: String,
    val email: String
) : Serializable

fun AccountLoginRemoteData.toDomain() =
    AccountToken(
        token = this.token
    )
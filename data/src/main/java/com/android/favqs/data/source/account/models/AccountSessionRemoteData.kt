package com.android.favqs.data.source.account.models

import com.android.favqs.domain.models.account.AccountToken
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AccountSessionRemoteData(
    @SerializedName("User-Token") val token: String,
    val login: String,
    val email: String
) : Serializable

fun AccountSessionRemoteData.toDomain() = AccountToken(
    token = this.token
)
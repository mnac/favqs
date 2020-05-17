package com.android.favqs.data.source.account.models

import com.android.favqs.domain.models.account.AccountToken
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AccountSessionRemoteData(
    @SerializedName("User-Token") val token: String?,
    val login: String?,
    val email: String?,
    @SerializedName("error_code") val errorCode: Int?,
    val message: String?
) : Serializable

fun AccountSessionRemoteData.toDomain() = AccountToken(
    login = this.login!!,
    token = this.token
)
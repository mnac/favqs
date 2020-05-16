package com.android.favqs.data.source.account.models.params

import java.io.Serializable

data class AccountLoginUserParamsData(
    val login: String,
    val password: String
) : Serializable
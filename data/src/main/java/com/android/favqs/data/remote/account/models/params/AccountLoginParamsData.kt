package com.android.favqs.data.remote.account.models.params

import java.io.Serializable

data class AccountLoginParamsData(
    val user: AccountLoginUserParamsData
) : Serializable
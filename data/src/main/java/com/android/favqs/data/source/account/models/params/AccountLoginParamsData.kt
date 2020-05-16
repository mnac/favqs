package com.android.favqs.data.source.account.models.params

import java.io.Serializable

data class AccountLoginParamsData(
    val user: AccountLoginUserParamsData
) : Serializable
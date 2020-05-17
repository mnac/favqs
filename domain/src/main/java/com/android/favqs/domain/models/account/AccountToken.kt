package com.android.favqs.domain.models.account

import java.io.Serializable

data class AccountToken(val login: String, val token: String?) : Serializable
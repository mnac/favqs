package com.android.favqs.data.source.account

import com.android.favqs.domain.models.account.AccountToken

interface AccountDataSource {
    interface Remote : AccountDataSource {
        suspend fun loginAccount(email: String, password: String): AccountToken
    }

    interface Local : AccountDataSource {
        suspend fun saveAccountToken(accountSessionToken: AccountToken)
        suspend fun getAccountToken(): AccountToken
    }
}
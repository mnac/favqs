package com.android.favqs.data.source.account

import com.android.favqs.domain.models.account.AccountToken
import com.android.favqs.domain.models.account.AccountUser

interface AccountDataSource {
    interface Remote : AccountDataSource {
        suspend fun loginAccount(email: String, password: String): AccountToken
        suspend fun getAccount(login: String): AccountUser
    }

    interface Local : AccountDataSource {
        suspend fun saveAccountToken(accountSessionToken: AccountToken)
        suspend fun getAccountToken(): AccountToken
        suspend fun saveAccountUser(user: AccountUser)
        suspend fun getAccountUser(login: String): AccountUser
    }
}
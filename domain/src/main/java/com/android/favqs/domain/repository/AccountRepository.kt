package com.android.favqs.domain.repository

import com.android.favqs.domain.models.account.AccountUser

interface AccountRepository {
    suspend fun getAccountUser(): AccountUser
    suspend fun connectUser(email: String, password: String): AccountUser
}
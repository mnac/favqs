package com.android.favqs.domain.repository

interface AccountRepository {
    suspend fun connectUser(email: String, password: String): Boolean
}
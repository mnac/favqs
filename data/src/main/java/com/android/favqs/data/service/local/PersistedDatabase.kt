package com.android.favqs.data.service.local

import com.android.favqs.domain.models.account.AccountUser
import com.android.favqs.domain.models.quotes.Quote

interface PersistedDatabase {
    suspend fun saveAccountUser(user: AccountUser)
    suspend fun getAccountUser(login: String): AccountUser?
    suspend fun saveQuotes(quotes: List<Quote>)
    suspend fun getQuotes(): List<Quote>?
}
package com.android.favqs.domain.repository

import com.android.favqs.domain.models.quotes.Quote

interface QuotesRepository {
    suspend fun getFavoritesQuotes(): List<Quote>
}
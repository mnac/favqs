package com.android.favqs.data.source.quotes

import com.android.favqs.domain.models.quotes.Quote

interface QuotesDataSource {

    suspend fun getFavoritesQuotes(login: String): List<Quote>

    interface Remote : QuotesDataSource

    interface Local : QuotesDataSource {
        suspend fun saveFavoritesQuotes(quotes: List<Quote>)
    }
}
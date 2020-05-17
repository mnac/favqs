package com.android.favqs.data.source.quotes

import com.android.favqs.data.exception.LocalQuotesNotAvailable
import com.android.favqs.data.service.local.PersistedDatabase
import com.android.favqs.domain.models.quotes.Quote
import javax.inject.Inject

class QuotesLocalDataSource @Inject constructor(
    private val persistedDatabase: PersistedDatabase
) : QuotesDataSource.Local {

    override suspend fun saveFavoritesQuotes(quotes: List<Quote>) {
        return persistedDatabase.saveQuotes(quotes)
    }

    override suspend fun getFavoritesQuotes(login: String): List<Quote> {
        return persistedDatabase.getQuotes() ?: throw LocalQuotesNotAvailable()
    }
}
package com.android.favqs.data.repository

import com.android.favqs.data.source.quotes.QuotesDataSource
import com.android.favqs.domain.models.quotes.Quote
import com.android.favqs.domain.repository.QuotesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuotesRepositoryImpl @Inject constructor(
    private val localSource: QuotesDataSource.Local,
    private val remoteSource: QuotesDataSource.Remote
) : QuotesRepository {
    override suspend fun getFavoritesQuotes(login: String): List<Quote> {
        return try {
            val quotes = remoteSource.getFavoritesQuotes(login = login)
            if (quotes.isNotEmpty()) localSource.saveFavoritesQuotes(quotes)
            quotes
        } catch (e: Exception) {
            localSource.getFavoritesQuotes(login = login)
        }
    }
}
package com.android.favqs.data.source.quotes

import com.android.favqs.data.service.remote.quote.QuotesRemoteService
import com.android.favqs.data.source.quotes.models.toDomain
import com.android.favqs.domain.models.quotes.Quote
import javax.inject.Inject

class QuotesRemoteDataSource @Inject constructor(
    private val quotesRemoteService: QuotesRemoteService
) : QuotesDataSource.Remote {
    companion object {
        private const val TYPE_USER = "user"
    }

    override suspend fun getFavoritesQuotes(login: String): List<Quote> {
        return quotesRemoteService
            .getQuotes(type = TYPE_USER, login = login)
            .quotes
            .map {
                it.toDomain()
            }
    }
}
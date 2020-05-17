package com.android.favqs.data.source.quotes

import com.android.favqs.data.service.remote.quote.QuotesRemoteService
import javax.inject.Inject

class QuotesRemoteDataSource @Inject constructor(
    private val quotesRemoteService: QuotesRemoteService
) : QuotesDataSource.Remote {
    override suspend fun getFavoritesQuotes() {
        TODO("Not yet implemented")
    }
}
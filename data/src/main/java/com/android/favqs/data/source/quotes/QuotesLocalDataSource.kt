package com.android.favqs.data.source.quotes

import javax.inject.Inject

class QuotesLocalDataSource @Inject constructor() : QuotesDataSource.Local {
    override suspend fun getFavoritesQuotes() {
        TODO("Not yet implemented")
    }
}
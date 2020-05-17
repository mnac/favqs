package com.android.favqs.data.source.quotes

interface QuotesDataSource {

    suspend fun getFavoritesQuotes()

    interface Remote : QuotesDataSource

    interface Local : QuotesDataSource
}
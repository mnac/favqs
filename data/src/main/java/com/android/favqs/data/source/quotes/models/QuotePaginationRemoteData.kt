package com.android.favqs.data.source.quotes.models

import com.android.favqs.domain.models.quotes.QuotePagination
import java.io.Serializable

data class QuotePaginationRemoteData(
    val page: Int,
    val lastPage: Boolean,
    val quotes: List<QuoteRemoteData>
) : Serializable

fun QuotePaginationRemoteData.toDomain() =
    QuotePagination(
        page = page,
        lastPage = lastPage,
        quotes = quotes.map { it.toDomain() }
    )

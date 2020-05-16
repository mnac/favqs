package com.android.favqs.data.source.quotes.models

import com.android.favqs.domain.models.quotes.Quote
import java.io.Serializable

data class QuoteRemoteData(
    val author: String,
    val body: String
) : Serializable

fun QuoteRemoteData.toDomain() = Quote(
    author = this.author,
    body = this.body
)
package com.android.favqs.domain.models.quotes

import com.android.favqs.domain.models.quotes.Quote
import java.io.Serializable

data class QuotePagination(
    val page: Int,
    val lastPage: Boolean,
    val quotes: List<Quote>
) : Serializable
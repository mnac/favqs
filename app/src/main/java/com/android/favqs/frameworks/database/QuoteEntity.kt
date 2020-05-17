package com.android.favqs.frameworks.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.favqs.domain.models.quotes.Quote

@Entity
data class QuoteEntity(
    @PrimaryKey val body: String,
    val author: String
) {
    companion object {
        fun fromDomain(quote: Quote) =
            QuoteEntity(
                body = quote.body,
                author = quote.author
            )
    }
}

fun QuoteEntity.toDomain() = Quote(
    author = this.author,
    body = this.body
)
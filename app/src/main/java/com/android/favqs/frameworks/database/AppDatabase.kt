package com.android.favqs.frameworks.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.favqs.data.exception.LocalAccountUserNotAvailable
import com.android.favqs.data.service.local.PersistedDatabase
import com.android.favqs.domain.models.account.AccountUser
import com.android.favqs.domain.models.quotes.Quote

@Database(entities = [AccountUserEntity::class, QuoteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(), PersistedDatabase {
    abstract fun accountDao(): AccountDao
    abstract fun quoteDao(): QuoteDao

    override suspend fun saveAccountUser(user: AccountUser) {
        accountDao().insert(AccountUserEntity.fromDomain(user))
    }

    override suspend fun getAccountUser(login: String): AccountUser? {
        return accountDao().get(login = login)?.toDomain()
    }

    override suspend fun saveQuotes(quotes: List<Quote>) {
        quoteDao().insert(quotes = quotes.map { QuoteEntity.fromDomain(it) })
    }

    override suspend fun getQuotes(): List<Quote> {
        return quoteDao().getQuotes()?.map { it.toDomain() }.toList()
    }
}
package com.android.favqs.frameworks.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(quotes: List<QuoteEntity>)

    @Query("SELECT * FROM quoteentity")
    suspend fun getQuotes(): Array<QuoteEntity>
}
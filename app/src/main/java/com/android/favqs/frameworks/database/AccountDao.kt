package com.android.favqs.frameworks.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: AccountUserEntity)

    @Query("SELECT * FROM accountuserentity where login == :login")
    suspend fun get(login: String): AccountUserEntity?
}
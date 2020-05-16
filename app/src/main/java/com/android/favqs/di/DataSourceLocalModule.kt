package com.android.favqs.di

import com.android.favqs.data.service.local.PersistedPreferences
import com.android.favqs.data.source.account.AccountDataSource
import com.android.favqs.data.source.account.AccountLocalDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceLocalModule {
    @Provides
    @Singleton
    fun accountRemoteService(localPreferences: PersistedPreferences): AccountDataSource.Local {
        return AccountLocalDataSource(persistedPreferences = localPreferences)
    }
}
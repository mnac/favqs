package com.android.favqs.di

import com.android.favqs.data.source.account.AccountDataSource
import com.android.favqs.data.source.account.AccountRemoteDataSource
import com.android.favqs.data.service.remote.account.AccountRemoteService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceRemoteModule {
    @Provides
    @Singleton
    fun remoteAccountDataSource(accountRemoteService: AccountRemoteService)
            : AccountDataSource.Remote {
        return AccountRemoteDataSource(accountRemoteService)
    }
}
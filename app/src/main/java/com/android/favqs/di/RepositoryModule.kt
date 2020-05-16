package com.android.favqs.di

import com.android.favqs.data.repository.AccountRepositoryImpl
import com.android.favqs.data.service.remote.SessionInterceptor
import com.android.favqs.data.source.account.AccountDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun accountRepository(
        localDataSource: AccountDataSource.Local,
        remoteDataSource: AccountDataSource.Remote,
        sessionInterceptor: SessionInterceptor
    ): AccountRepositoryImpl {
        return AccountRepositoryImpl(
            localSource = localDataSource,
            remoteSource = remoteDataSource,
            sessionInterceptor = sessionInterceptor
        )
    }
}
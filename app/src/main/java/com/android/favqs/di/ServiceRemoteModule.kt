package com.android.favqs.di

import com.android.favqs.data.service.remote.account.AccountRemoteService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceRemoteModule {
    @Provides
    @Singleton
    fun accountRemoteService(client: Retrofit): AccountRemoteService {
        return client.create(AccountRemoteService::class.java)
    }
}
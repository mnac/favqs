package com.android.favqs.data.repository

import com.android.favqs.data.service.remote.SessionInterceptor
import com.android.favqs.data.source.account.AccountDataSource
import com.android.favqs.domain.repository.AccountRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccountRepositoryImpl @Inject constructor(
    private val localSource: AccountDataSource.Local,
    private val remoteSource: AccountDataSource.Remote,
    private val sessionInterceptor: SessionInterceptor
) : AccountRepository {
    override suspend fun connectUser(email: String, password: String): Boolean {
        val accountSessionToken = remoteSource.loginAccount(email = email, password = password)
        localSource.saveAccountToken(accountSessionToken = accountSessionToken)
        sessionInterceptor.setSessionToken(accountSessionToken.token)
        return true
    }
}